package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTOs
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import com.mmcm.projectocp.backend.spring.domain.repository.RoleRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class UserRoleMapper(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository
): EntityMapper<UserRole, UserRoleDTOs.GetResult, UserRoleDTOs.PostRequest, UserRoleDTOs.PutRequest> {
    override fun toGetResult(
        entity: UserRole
    ): UserRoleDTOs.GetResult {
        return UserRoleDTOs.GetResult(
            id = entity.id,
            user = entity.user.email,
            role = entity.role.name
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: UserRoleDTOs.PostRequest
    ): UserRole {
        return UserRole(
            id = id,
            user = userRepository.findByEmail(entityRequest.user).getOrNull()
                ?: userRepository.findById(entityRequest.user).get(),
            role = roleRepository.findByName(entityRequest.role).getOrNull()
                ?: roleRepository.findById(entityRequest.role).get(),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: UserRole,
        entityRequest: UserRoleDTOs.PutRequest
    ): UserRole {
        return UserRole(
            id = entity.id,
            user = userRepository.findByEmail(entityRequest.user).getOrNull()
                ?: userRepository.findById(entityRequest.user ?: entity.user.id).get(),
            role = roleRepository.findByName(entityRequest.role).getOrNull()
                ?: roleRepository.findById(entityRequest.role ?: entity.role.id).get(),
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}