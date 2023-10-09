package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.ContentDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Content
import com.mmcm.projectocp.backend.spring.domain.repository.ContentTypeRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class ContentMapper(
    private val contentTypeRepository: ContentTypeRepository,
    private val userRepository: UserRepository
): EntityMapper<Content, ContentDTOs.GetResult, ContentDTOs.PostRequest, ContentDTOs.PutRequest> {
    override fun toGetResult(
        entity: Content
    ): ContentDTOs.GetResult {
        return ContentDTOs.GetResult(
            id = entity.id,
            contentType = entity.contentType.type,
            author = entity.author.email,
            title = entity.title,
            content = entity.content,
            isActive = entity.isActive
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: ContentDTOs.PostRequest
    ): Content {
        return Content(
            id = id,
            contentType = contentTypeRepository.findByType(entityRequest.contentType).get(),
            author = userRepository.findByEmail(entityRequest.author).get(),
            title = entityRequest.title,
            content = entityRequest.content,
            isActive = entityRequest.isActive,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Content,
        entityRequest: ContentDTOs.PutRequest
    ): Content {
        return Content(
            id = entity.id,
            contentType = contentTypeRepository.findByType(entityRequest.contentType).getOrNull() ?: entity.contentType,
            author = userRepository.findByEmail(entityRequest.author).getOrNull() ?: entity.author,
            title = entityRequest.title ?: entity.title,
            content = entityRequest.content ?: entity.content,
            isActive = entityRequest.isActive ?: entity.isActive,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}