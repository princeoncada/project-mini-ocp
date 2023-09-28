package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.LinkTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.LinkType
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class LinkTypeMapper: EntityMapper<LinkType, LinkTypeDTOs.GetResult, LinkTypeDTOs.PostRequest, LinkTypeDTOs.PutRequest> {
    override fun toGetResult(
        entity: LinkType
    ): LinkTypeDTOs.GetResult {
        return LinkTypeDTOs.GetResult(
            id = entity.id,
            type = entity.type
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: LinkTypeDTOs.PostRequest
    ): LinkType {
        return LinkType(
            id = id,
            type = entityRequest.type,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: LinkType,
        entityRequest: LinkTypeDTOs.PutRequest
    ): LinkType {
        return LinkType(
            id = entity.id,
            type = entityRequest.type,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}