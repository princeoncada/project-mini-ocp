package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.PermissionDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Permission
import org.springframework.stereotype.Component
import java.time.Instant
@Component
class PermissionMapper: EntityMapper<Permission, PermissionDTOs.GetResult, PermissionDTOs.PostRequest, PermissionDTOs.PutRequest> {
    override fun toGetResult(
        entity: Permission
    ): PermissionDTOs.GetResult {
        return PermissionDTOs.GetResult(
            id = entity.id,
            name = entity.name
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: PermissionDTOs.PostRequest)
    : Permission {
        return Permission(
            id = id,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Permission,
        entityRequest: PermissionDTOs.PutRequest
    ): Permission {
        return Permission(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}