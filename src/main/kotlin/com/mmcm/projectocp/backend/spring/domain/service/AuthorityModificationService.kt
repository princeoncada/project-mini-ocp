package com.mmcm.projectocp.backend.spring.domain.service

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class AuthorityModificationService(
        private val userRoleService: UserRoleService
) {

    fun modifyAuthorities(authentication: Authentication): List<String> {
        val newAuthorities = mutableListOf<GrantedAuthority>()
        authentication.authorities.forEach { presentAuthority ->
            newAuthorities.add(presentAuthority)
        }

        val oauth2User: OAuth2User = authentication.principal as OAuth2User
        val email: String = oauth2User.getAttribute<String>("email").toString()
        val userRole = userRoleService.findByEmail(email)

        if ((!newAuthorities.any { it.authority == "ROLE_${userRole.role.name}" })) {
            newAuthorities.add(GrantedAuthority { "ROLE_${userRole.role.name}" } )
            println("${userRole.user.email} assigned with their role ${userRole.role.name}")
        }else {
            println("${userRole.user.email} already has their role ${userRole.role.name} in Authority!")
        }

        val newAuth = UsernamePasswordAuthenticationToken(
                authentication.principal,
                authentication.credentials,
                newAuthorities
        )

        SecurityContextHolder.getContext().authentication = newAuth
        return authentication.authorities.map { it.authority }
    }

}