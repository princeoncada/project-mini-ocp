package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserPermissionDTOs
import com.mmcm.projectocp.backend.spring.domain.model.UserPermission
import com.mmcm.projectocp.backend.spring.domain.model.UserPermissionKey
import com.mmcm.projectocp.backend.spring.domain.repository.PermissionRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class UserPermissionMapper(
    private val userRepository: UserRepository,
    private val permissionRepository: PermissionRepository
) {
    fun toGetResult(entity: UserPermission): UserPermissionDTOs.GetResult {
        return UserPermissionDTOs.GetResult(
            userId = entity.id.userId,
            permissionId = entity.id.permissionId,
            user = userRepository.findById(entity.id.userId).get().email,
            permission = permissionRepository.findById(entity.id.permissionId).get().name
        )
    }

    fun createEntity(entityRequest: UserPermissionDTOs.PostRequest): UserPermission {
        return UserPermission(
            id = UserPermissionKey(
                userId = userRepository.findByEmail(entityRequest.user).get().id,
                permissionId = permissionRepository.findByName(entityRequest.permission).get().id
            ),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    fun updateEntity(entity: UserPermission, entityRequest: UserPermissionDTOs.PutRequest): UserPermission {
        return UserPermission(
            id = UserPermissionKey(
                userId = userRepository.findByEmail(entityRequest.user).getOrNull()?.id ?: entity.id.userId,
                permissionId = permissionRepository.findByName(entityRequest.permission).getOrNull()?.id ?: entity.id.permissionId
            ),
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}