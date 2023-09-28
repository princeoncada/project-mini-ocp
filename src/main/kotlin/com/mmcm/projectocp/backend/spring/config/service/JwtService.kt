package com.mmcm.projectocp.backend.spring.config.service

import com.mmcm.projectocp.backend.spring.domain.repository.RefreshTokenRepository
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.JwtValidationException
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService(
    private val secretKey: SecretKey,
    private val refreshTokenRepository: RefreshTokenRepository
){
    fun generateToken(principal: UserPrincipal, authorities: MutableCollection<out GrantedAuthority>): String {
        val now = Date()
        val validity = Date(now.time + ACCESS_TOKEN_VALIDITY)
        return Jwts.builder()
            .setIssuer("https://localhost:8080/authenticate")
            .setSubject(principal.username)
            .setAudience("authenticate-api")
            .setId(principal.getUserId())
            .setExpiration(validity)
            .setIssuedAt(now)
            .claim("authorities", authorities.map { it.authority })
            .signWith(secretKey)
            .compact()
    }

    fun generateRefreshToken(principal: UserPrincipal, authorities: MutableCollection<out GrantedAuthority>): String {
        val now = Date()
        val validity = Date(now.time + REFRESH_TOKEN_VALIDITY)
        return Jwts.builder()
            .setIssuer("https://localhost:8080/authenticate")
            .setSubject(principal.username)
            .setAudience("authenticate-api")
            .setId(principal.getUserId())
            .setExpiration(validity)
            .setIssuedAt(now)
            .claim("authorities", authorities.map { it.authority })
            .signWith(secretKey)
            .compact()
    }

    fun getClaims(token: String?): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
    }

    fun isTokenExpired(token: String?): Boolean {
        return getClaims(token).expiration.before(Date())
    }

    fun validateToken(token: String?, userDetails: UserPrincipal): Boolean {
        return getClaims(token).subject == userDetails.username && !isTokenExpired(token)
    }

    fun createCookie(token: String = "", age: Int = 0): Cookie {
        return Cookie("jwtToken", token).apply {
            maxAge = age
            isHttpOnly = true
            path = "/"
            domain = "localhost"
        }
    }

    fun clearAccessTokenCookie(response: HttpServletResponse) {
        val cookie = createCookie(age = 0)
        response.addCookie(cookie)
    }

    fun revokeRefreshToken(userId: String) {
        val refreshToken = refreshTokenRepository.findByUserId(userId)
        if(refreshToken.isPresent) {
            refreshTokenRepository.delete(refreshToken.get())
        }

    }

    companion object {
        private const val TOKEN_EXPIRY_TEST = 60000L // Token validity: 1 minute
        private const val ACCESS_TOKEN_VALIDITY = 3600000L // Token validity: 1 hour
        private const val REFRESH_TOKEN_VALIDITY = 86400000L // Token validity: 1 day
    }
}