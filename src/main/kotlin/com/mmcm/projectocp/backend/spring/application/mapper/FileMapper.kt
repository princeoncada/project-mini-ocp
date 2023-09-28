package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.FileDTOs
import com.mmcm.projectocp.backend.spring.domain.model.File
import com.mmcm.projectocp.backend.spring.domain.repository.FileTypeRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class FileMapper(
    private val fileTypeRepository: FileTypeRepository,
    private val userRepository: UserRepository
): EntityMapper<File, FileDTOs.GetResult, FileDTOs.PostRequest, FileDTOs.PutRequest> {
    override fun toGetResult(
        entity: File
    ): FileDTOs.GetResult {
        return FileDTOs.GetResult(
            id = entity.id,
            fileType = entity.fileType.name,
            parentId = entity.parentId,
            name = entity.name,
            mimetype = entity.mimetype,
            path = entity.path,
            key = entity.key,
            uploadedBy = entity.uploadedBy.email,
            order = entity.order,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: FileDTOs.PostRequest
    ): File {
        return File(
            id = id,
            fileType = fileTypeRepository.findByName(entityRequest.fileType).get(),
            parentId = entityRequest.parentId,
            name = entityRequest.name,
            mimetype = entityRequest.mimetype,
            path = entityRequest.path,
            key = entityRequest.key,
            uploadedBy = userRepository.findByEmail(entityRequest.uploadedBy).get(),
            order = entityRequest.order,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: File,
        entityRequest: FileDTOs.PutRequest
    ): File {
        return File(
            id = entity.id,
            fileType = fileTypeRepository.findByName(entityRequest.fileType).getOrNull() ?: entity.fileType,
            parentId = entityRequest.parentId ?: entity.parentId,
            name = entityRequest.name ?: entity.name,
            mimetype = entityRequest.mimetype ?: entity.mimetype,
            path = entityRequest.path ?: entity.path,
            key = entityRequest.key ?: entity.key,
            uploadedBy = userRepository.findByEmail(entityRequest.uploadedBy).getOrNull() ?: entity.uploadedBy,
            order = entityRequest.order ?: entity.order,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}