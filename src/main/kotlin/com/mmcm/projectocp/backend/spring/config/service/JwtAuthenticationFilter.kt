package com.mmcm.projectocp.backend.spring.config.service

import io.jsonwebtoken.ExpiredJwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtService: JwtService,
    private val userDetailsService: CustomUserDetailsServiceImpl
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header: String? = request.getHeader("Authorization")
        if (header == null || !header.startsWith("Bearer " ) || SecurityContextHolder.getContext().authentication == null) {
            filterChain.doFilter(request, response)
            return
        }

        try {
            val token: String = header.substring(7)
            val username = jwtService.getUsername(token)
            val userPrincipal = userDetailsService.loadUserByUsername(username)

            if (jwtService.validateToken(token, userPrincipal)) {
                val authentication = UsernamePasswordAuthenticationToken(
                    userPrincipal,
                    null,
                    userPrincipal.authorities
                )
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication
            }

        } catch (e: ExpiredJwtException) {
            println("Token expired")
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }

        filterChain.doFilter(request, response)
    }
}