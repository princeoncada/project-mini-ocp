package com.mmcm.projectocp.backend.spring.config.service

import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomPrincipalService(
    private val userRepository: UserRepository,
    private val userRoleRepository: UserRoleRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserPrincipal {
        val user = userRepository.findByEmail(email).get()
        val userRole = userRoleRepository.findByUserId(user.id)
        return UserPrincipal(userRole)
    }
}