package com.mmcm.projectocp.backend.spring.config.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Service
import java.util.*
import javax.crypto.SecretKey

@Service
class JwtService(
    private val secretKey: SecretKey
){
    fun generateToken(principal: UserPrincipal, authorities: MutableCollection<out GrantedAuthority>): String {
        val now = Date()
        val validity = Date(now.time + TOKEN_VALIDITY)
        return Jwts.builder()
            .setIssuer("https://localhost:8080/authenticate")
            .setSubject(principal.username)
            .setAudience("authenticate-api")
            .setId(principal.getUserId())
//            .setExpiration(validity)
            .setExpiration(Date(now.time + TOKEN_EXPIRY_TEST))
            .setIssuedAt(now)
            .claim("authorities", authorities.map { it.authority })
            .signWith(secretKey)
            .compact()
    }

    fun getClaims(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
    }

    fun isTokenExpired(token: String): Boolean {
        return getClaims(token).expiration.before(Date())
    }

    fun validateToken(token: String, userDetails: UserPrincipal): Boolean {
        return getClaims(token).subject == userDetails.username && !isTokenExpired(token)
    }

    companion object {
        private const val TOKEN_EXPIRY_TEST = 90000L // Token expiry test: 1.5 minutes
        private const val TOKEN_VALIDITY = 3600000L // Token validity: 1 hour
    }
}