package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.config.service.JwtService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Pageable
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.view.RedirectView

@RestController
class AuthController (
    private val jwtService: JwtService,
    @Qualifier("customUserDetailsServiceImpl") private val userDetailsService: UserDetailsService
) {
    @GetMapping("/authenticate")
    fun authenticate(pageable: Pageable, authentication: Authentication): RedirectView {
        val userDetails = userDetailsService.loadUserByUsername(authentication.name)
        val newAuthorities = mutableListOf<GrantedAuthority>()
        authentication.authorities.forEach { presentAuthority -> newAuthorities.add(presentAuthority) }
        userDetails.authorities.forEach { newAuthority -> newAuthorities.add(newAuthority) }
        SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                newAuthorities
        )
        val token = jwtService.generateToken(authentication.name, newAuthorities)
        println(token)
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
}