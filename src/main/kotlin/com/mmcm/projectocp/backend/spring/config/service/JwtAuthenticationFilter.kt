package com.mmcm.projectocp.backend.spring.config.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Header
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtService: JwtService,
    private val userPrincipalService: CustomUserDetailsServiceImpl
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header: String? = request.getHeader("Authorization")
        if (header == null || !header.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        try {
            val token: String = header.substring(7)
            val payload: Claims = jwtService.getClaims(token)
            val userPrincipal: UserPrincipal = userPrincipalService.loadUserByUsername(payload.subject)

            if (jwtService.validateToken(token, userPrincipal)) {
                val roles = payload["authorities"] as List<*>
                val authorities = roles.map { SimpleGrantedAuthority(it as String) }
                val authenticationToken = UsernamePasswordAuthenticationToken(
                    userPrincipal.username,
                    null,
                    authorities
                )
                authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authenticationToken
            }

            if (jwtService.isTokenExpired(token)) throw ExpiredJwtException(null, payload, "Token expired")
        } catch (e: ExpiredJwtException) {
            println("Token expired!!")
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }

        filterChain.doFilter(request, response)
    }
}