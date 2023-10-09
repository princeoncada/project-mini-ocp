package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.ContentTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.ContentType
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class ContentTypeMapper: EntityMapper<ContentType, ContentTypeDTOs.GetResult, ContentTypeDTOs.PostRequest, ContentTypeDTOs.PutRequest> {
    override fun toGetResult(
        entity: ContentType
    ): ContentTypeDTOs.GetResult {
        return ContentTypeDTOs.GetResult(
            id = entity.id,
            type = entity.type
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: ContentTypeDTOs.PostRequest
    ): ContentType {
        return ContentType(
            id = id,
            type = entityRequest.type,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: ContentType,
        entityRequest: ContentTypeDTOs.PutRequest
    ): ContentType {
        return ContentType(
            id = entity.id,
            type = entityRequest.type,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}