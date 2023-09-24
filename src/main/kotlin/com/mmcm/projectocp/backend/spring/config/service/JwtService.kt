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
    fun generateToken(email: String, authorities: MutableCollection<out GrantedAuthority>): String {
        val now = Date()
        val validity = Date(now.time + TOKEN_VALIDITY)
        return Jwts.builder()
            .setSubject(email)
            .setIssuedAt(now)
            .setExpiration(validity)
            .claim("authorities", authorities.map { it.authority })
            .signWith(secretKey)
            .compact()
    }

    fun getPayload(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(secretKey)
            .build()
            .parseClaimsJws(token)
            .body
    }

    companion object {
        private const val TOKEN_VALIDITY = 3600000L // Token validity: 1 hour
    }
}