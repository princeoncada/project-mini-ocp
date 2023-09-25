package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.FileTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.FileType
import com.mmcm.projectocp.backend.spring.domain.repository.FileTypeRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class FileTypeMapper: EntityMapper<FileType, FileTypeDTOs.GetResult, FileTypeDTOs.PostRequest, FileTypeDTOs.PutRequest> {
    override fun toGetResult(
        entity: FileType
    ): FileTypeDTOs.GetResult {
        return FileTypeDTOs.GetResult(
            id = entity.id,
            name = entity.name,
            abbr = entity.abbr
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: FileTypeDTOs.PostRequest
    ): FileType {
        return FileType(
            id = id,
            name = entityRequest.name,
            abbr = entityRequest.abbr,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: FileType,
        entityRequest: FileTypeDTOs.PutRequest
    ): FileType {
        return FileType(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            abbr = entityRequest.abbr ?: entity.abbr,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}
