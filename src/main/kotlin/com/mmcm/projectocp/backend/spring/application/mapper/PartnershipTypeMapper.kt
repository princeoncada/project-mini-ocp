package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.PartnershipTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.PartnershipType
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class PartnershipTypeMapper: EntityMapper<PartnershipType, PartnershipTypeDTOs.GetResult, PartnershipTypeDTOs.PostRequest, PartnershipTypeDTOs.PutRequest>{
    override fun toGetResult(
        entity: PartnershipType
    ): PartnershipTypeDTOs.GetResult {
        return PartnershipTypeDTOs.GetResult(
            id = entity.id,
            type = entity.type
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: PartnershipTypeDTOs.PostRequest
    ): PartnershipType {
        return PartnershipType(
            id = id,
            type = entityRequest.type,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: PartnershipType,
        entityRequest: PartnershipTypeDTOs.PutRequest
    ): PartnershipType {
        return PartnershipType(
            id = entity.id,
            type = entityRequest.type ?: entity.type,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}
