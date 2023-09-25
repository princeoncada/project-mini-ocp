package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MCStatusDTOs
import com.mmcm.projectocp.backend.spring.domain.model.MCStatus
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class MCStatusMapper: EntityMapper<MCStatus, MCStatusDTOs.GetResult, MCStatusDTOs.PostRequest, MCStatusDTOs.PutRequest> {
    override fun toGetResult(
        entity: MCStatus
    ): MCStatusDTOs.GetResult {
        return MCStatusDTOs.GetResult(
            id = entity.id,
            name = entity.name,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MCStatusDTOs.PostRequest
    ): MCStatus {
        return MCStatus(
            id = id,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: MCStatus,
        entityRequest: MCStatusDTOs.PutRequest
    ): MCStatus {
        return MCStatus(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}