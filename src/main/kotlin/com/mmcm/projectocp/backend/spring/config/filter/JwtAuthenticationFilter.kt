package com.mmcm.projectocp.backend.spring.config.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.mmcm.projectocp.backend.spring.config.service.CustomPrincipalService
import com.mmcm.projectocp.backend.spring.config.service.JwtService
import com.mmcm.projectocp.backend.spring.config.service.UserPrincipal
import com.mmcm.projectocp.backend.spring.domain.repository.RefreshTokenRepository
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.JwtValidationException
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtService: JwtService,
    private val userPrincipalService: CustomPrincipalService,
    private val refreshTokenRepository: RefreshTokenRepository
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            var jwtToken: String? = null
            val cookies: Array<Cookie>? = request.cookies
            if (cookies != null) {
                for (cookie in cookies) {
                    if (cookie.name == "jwtToken") {
                        jwtToken = cookie.value
                    }
                }
            }

            if (jwtToken == null) {
                val authorizationHeader: String? = request.getHeader("Authorization")
                if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                    jwtToken = authorizationHeader.substring(7)
                } else {
                    filterChain.doFilter(request, response)
                    return
                }
            }

            val payload: Claims = jwtService.getClaims(jwtToken)
            val userPrincipal: UserPrincipal = userPrincipalService.loadUserByUsername(payload.subject)

            if (!jwtService.validateToken(jwtToken, userPrincipal)) throw JwtValidationException("Invalid token", null)
            if (jwtService.isTokenExpired(jwtToken)) throw ExpiredJwtException(null, payload, "Token expired")

            val roles = payload["authorities"] as List<*>
            val authorities = roles.map { SimpleGrantedAuthority(it as String) }
            val authenticationToken = UsernamePasswordAuthenticationToken(
                userPrincipal.username,
                null,
                authorities
            )
            authenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authenticationToken
            filterChain.doFilter(request, response)

        } catch (e: ExpiredJwtException) {
            val user = userPrincipalService.loadUserByUsername(e.claims.subject)
            val refreshToken = refreshTokenRepository.findByUserId(e.claims.id).get()
            val authorities = SecurityContextHolder.getContext().authentication.authorities

            if (jwtService.validateToken(refreshToken.refreshToken, user)) {
                println("Refresh token is valid: ${refreshToken.refreshToken}")

                val newAccessToken = jwtService.generateToken(user, authorities)
                println("New access token: $newAccessToken")

                val cookie = jwtService.createCookie(newAccessToken, 3600)
                response.addCookie(cookie)
                response.status = HttpServletResponse.SC_OK
                response.contentType = "application/json"

                val responseBody = mapOf(
                    "token" to newAccessToken
                )

                response.writer.write(ObjectMapper().writeValueAsString(responseBody))
            } else {
                response.status = HttpServletResponse.SC_UNAUTHORIZED
                response.contentType = "application/json"
                val responseBody = mapOf(
                    "error" to "Unauthorized",
                    "message" to "Token expired for user ${e.claims.subject}"
                )
                response.writer.write(ObjectMapper().writeValueAsString(responseBody))
                val authentication = SecurityContextHolder.getContext().authentication
                jwtService.clearAccessTokenCookie(response)
                jwtService.revokeRefreshToken(authentication.name)
                SecurityContextHolder.getContext().authentication = null
                response.sendRedirect("/login")
            }

        } catch (e: Exception) {
            println("Error: ${e.message}")
            val authentication = SecurityContextHolder.getContext().authentication
            jwtService.clearAccessTokenCookie(response)
            jwtService.revokeRefreshToken(authentication.name)
            SecurityContextHolder.getContext().authentication = null
            response.sendRedirect("/login")
        }
    }
}