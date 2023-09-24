package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTOs
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import org.springframework.stereotype.Service
import java.util.*

@Service
interface UserRoleService: EntityService<UserRoleDTOs.GetResult, UserRoleDTOs.PostRequest, UserRoleDTOs.PutRequest> {
    fun isAdmin(userId: String): Boolean
    fun findByEmail(email: String): Optional<UserRole>
}