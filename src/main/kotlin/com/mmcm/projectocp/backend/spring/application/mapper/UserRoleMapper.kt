package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTO
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import org.springframework.stereotype.Component

@Component
class UserRoleMapper {
    fun toUserRoleDTO(userRole: UserRole): UserRoleDTO {
        return UserRoleDTO(
            id = userRole.id,
            user = userRole.user.email,
            role = userRole.role.name
        )
    }
}