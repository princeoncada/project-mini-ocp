package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.RequirementDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Requirement
import com.mmcm.projectocp.backend.spring.domain.repository.CourseRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class RequirementMapper(
    private val courseRepository: CourseRepository
): EntityMapper<Requirement, RequirementDTOs.GetResult, RequirementDTOs.PostRequest, RequirementDTOs.PutRequest> {
    override fun toGetResult(
        entity: Requirement
    ): RequirementDTOs.GetResult {
        return RequirementDTOs.GetResult(
            id = entity.id,
            course = entity.course.name,
            isVisible = entity.isVisible,
            title = entity.title,
            instructions = entity.instructions,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: RequirementDTOs.PostRequest
    ): Requirement {
        return Requirement(
            id = id,
            course = courseRepository.findByName(entityRequest.course).get(),
            isVisible = entityRequest.isVisible,
            title = entityRequest.title,
            instructions = entityRequest.instructions,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: Requirement,
        entityRequest: RequirementDTOs.PutRequest
    ): Requirement {
        return Requirement(
            id = entity.id,
            course = courseRepository.findByName(entityRequest.course).getOrNull() ?: entity.course,
            isVisible = entityRequest.isVisible ?: entity.isVisible,
            title = entityRequest.title ?: entity.title,
            instructions = entityRequest.instructions ?: entity.instructions,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}