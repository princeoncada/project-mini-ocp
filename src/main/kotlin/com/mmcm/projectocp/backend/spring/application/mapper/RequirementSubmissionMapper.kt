package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.RequirementSubmissionDTOs
import com.mmcm.projectocp.backend.spring.domain.model.RequirementSubmission
import com.mmcm.projectocp.backend.spring.domain.repository.RequirementRepository
import com.mmcm.projectocp.backend.spring.domain.repository.StudentCourseRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class RequirementSubmissionMapper(
    private val userRepository: UserRepository,
    private val studentCourseRepository: StudentCourseRepository,
    private val requirementRepository: RequirementRepository
): EntityMapper<RequirementSubmission, RequirementSubmissionDTOs.GetResult, RequirementSubmissionDTOs.PostRequest, RequirementSubmissionDTOs.PutRequest> {
    override fun toGetResult(
        entity: RequirementSubmission
    ): RequirementSubmissionDTOs.GetResult {
        return RequirementSubmissionDTOs.GetResult(
            id = entity.id,
            user = entity.user.email,
            studentCourse = entity.studentCourse.course.name,
            requirement = entity.requirement.course.name,
            status = entity.status,
            message = entity.message
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: RequirementSubmissionDTOs.PostRequest
    ): RequirementSubmission {
        return RequirementSubmission(
            id = id,
            user = userRepository.findByEmail(entityRequest.user).get(),
            studentCourse = studentCourseRepository.findByUser(userRepository.findByEmail(entityRequest.user).get()).get(),
            requirement = requirementRepository.findByTitle(entityRequest.requirement).get(),
            status = entityRequest.status,
            message = entityRequest.message,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: RequirementSubmission,
        entityRequest: RequirementSubmissionDTOs.PutRequest
    ): RequirementSubmission {
        return RequirementSubmission(
            id = entity.id,
            user = userRepository.findByEmail(entityRequest.user).getOrNull() ?: entity.user,
            studentCourse = studentCourseRepository.findByUser(userRepository.findByEmail(entityRequest.user).getOrNull()).getOrNull() ?: entity.studentCourse,
            requirement = requirementRepository.findByTitle(entityRequest.requirement).getOrNull() ?: entity.requirement,
            status = entityRequest.status ?: entity.status,
            message = entityRequest.message ?: entity.message,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}