package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRoleRepository: UserRoleRepository,
    private val userService: UserService
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found with username: $username")
        return UserPrincipal(user)
    }
}