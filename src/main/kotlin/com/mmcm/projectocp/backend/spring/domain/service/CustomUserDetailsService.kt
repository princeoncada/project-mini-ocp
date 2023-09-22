package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRoleRepository: UserRoleRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user = userRoleRepository.findByUserEmail(email)
            ?: throw UsernameNotFoundException("User not found with username: $email")
        return UserPrincipal(user)
    }
}