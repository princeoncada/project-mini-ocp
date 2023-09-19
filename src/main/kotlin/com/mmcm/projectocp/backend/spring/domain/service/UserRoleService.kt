package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import org.springframework.stereotype.Service

@Service
interface UserRoleService {
    fun isAdmin(userId: String): Boolean
    fun findByEmail(email: String): UserRole
}