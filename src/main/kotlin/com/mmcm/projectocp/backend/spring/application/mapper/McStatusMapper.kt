package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.McStatusDTOs
import com.mmcm.projectocp.backend.spring.domain.model.McStatus
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class McStatusMapper: EntityMapper<McStatus, McStatusDTOs.GetResult, McStatusDTOs.PostRequest, McStatusDTOs.PutRequest> {
    override fun toGetResult(
        entity: McStatus
    ): McStatusDTOs.GetResult {
        return McStatusDTOs.GetResult(
            id = entity.id,
            name = entity.name,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: McStatusDTOs.PostRequest
    ): McStatus {
        return McStatus(
            id = id,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: McStatus,
        entityRequest: McStatusDTOs.PutRequest
    ): McStatus {
        return McStatus(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}