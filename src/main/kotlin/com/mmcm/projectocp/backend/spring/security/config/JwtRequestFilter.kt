package com.mmcm.projectocp.backend.spring.security.config

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter


@Component
class JwtRequestFilter(
    private val jwtService: JwtService,
    private val userDetailsService: UserDetailsService

) : OncePerRequestFilter() {
    private val log = LoggerFactory.getLogger(JwtRequestFilter::class.java)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader: String? = request.getHeader("Authorization")

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Valid authorization header, proceed with token extraction
            val token: String = authHeader.substring(7)
            val username: String = jwtService.extractUsername(token)

            if (username.isNotEmpty() && SecurityContextHolder.getContext().authentication == null) {
                val userDetails = userDetailsService.loadUserByUsername(username)
                if (jwtService.isTokenValid(token, userDetails)) {
                    val authentication = UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.authorities
                    )
                    authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                    SecurityContextHolder.getContext().authentication = authentication
                }
            }
        }

        filterChain.doFilter(request, response)
        logRequest(request, response)
    }

    private fun logRequest(request: HttpServletRequest, response: HttpServletResponse) {
        log.info("Logging Request  {} : {}", request.method, request.requestURI)
        log.info("Logging Response :{}", response.status)
    }
}