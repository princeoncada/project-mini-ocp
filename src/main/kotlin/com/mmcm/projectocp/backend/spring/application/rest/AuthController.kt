package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.config.service.CustomPrincipalService
import com.mmcm.projectocp.backend.spring.config.service.JwtService
import com.mmcm.projectocp.backend.spring.domain.model.RefreshToken
import com.mmcm.projectocp.backend.spring.domain.repository.RefreshTokenRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.RedirectView
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@RestController
class AuthController (
    private val jwtService: JwtService,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val userRepository: UserRepository,
    private val userPrincipalService: CustomPrincipalService
) {
    @GetMapping("/oauth2/callback")
    fun authenticate(
        authentication: Authentication,
        request: HttpServletRequest,
        response: HttpServletResponse
    ): RedirectView {
        val userPrincipal = userPrincipalService.loadUserByUsername(authentication.name)
        val newAuthorities = mutableListOf<GrantedAuthority>()
        authentication.authorities.forEach { presentAuthority -> newAuthorities.add(presentAuthority) }
        userPrincipal.authorities.forEach { presentAuthority -> newAuthorities.add(presentAuthority) }

        SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(
            userPrincipal,
            null,
            newAuthorities
        )

        val accessToken = jwtService.generateToken(userPrincipal, newAuthorities)
        val refreshToken = jwtService.generateRefreshToken(userPrincipal, newAuthorities)
        val expirationDate = LocalDateTime.ofInstant(Date(Date().time
                + jwtService.getClaims(refreshToken).expiration.time).toInstant(), ZoneId.systemDefault())

        println("Initial token: $accessToken")

        refreshTokenRepository.save(
            RefreshToken(
                id = UUID.randomUUID().toString(),
                user = userRepository.findById(userPrincipal.getUserId()).get(),
                refreshToken = refreshToken,
                expirationDate = expirationDate,
                createdAt = Instant.now(),
                updatedAt = Instant.now()
            )
        )

        val cookie = jwtService.createCookie(accessToken, 3600)
        response.addCookie(cookie)
        return RedirectView("http://localhost:8080/")
    }

    @GetMapping("/")
    fun index(): ModelAndView {
        return ModelAndView("index")
    }

    @GetMapping("/current-user")
    fun testPrincipal(): Authentication {
        return SecurityContextHolder.getContext().authentication
    }

    @GetMapping("/check")
    fun check(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): RedirectView {
        request.cookies.forEach {
            println("Cookie: ${it.name} = ${it.value}")
        }
        return RedirectView("http://localhost:8080/")
    }
}