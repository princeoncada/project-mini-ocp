package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserRoleService
import org.springframework.stereotype.Service

@Service
class UserRoleServiceImpl(
        private val userRepository: UserRepository,
        private val userRoleRepository: UserRoleRepository
): UserRoleService {
    override fun isAdmin(userId: String): Boolean {
        return userRoleRepository.findByUserId(userId).role.name == "admin"
    }

    override fun findByEmail(email: String): UserRole {
        val userId = userRepository.findByEmail(email).id
        return userRoleRepository.findByUserId(userId)
    }
}