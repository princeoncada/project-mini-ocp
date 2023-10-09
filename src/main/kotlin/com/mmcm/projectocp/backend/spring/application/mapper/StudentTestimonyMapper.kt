package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.StudentTestimonyDTOs
import com.mmcm.projectocp.backend.spring.domain.model.StudentTestimony
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDate

@Component
class StudentTestimonyMapper: EntityMapper<StudentTestimony, StudentTestimonyDTOs.GetResult, StudentTestimonyDTOs.PostRequest, StudentTestimonyDTOs.PutRequest> {
    override fun toGetResult(
        entity: StudentTestimony
    ): StudentTestimonyDTOs.GetResult {
        return StudentTestimonyDTOs.GetResult(
            id = entity.id,
            studentCompaniesAttendedId = entity.studentCompaniesAttendedId,
            review = entity.review,
            rating = entity.rating,
            dateApproved = entity.dateApproved.toString()
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: StudentTestimonyDTOs.PostRequest
    ): StudentTestimony {
        return StudentTestimony(
            id = id,
            studentCompaniesAttendedId = entityRequest.studentCompaniesAttendedId,
            review = entityRequest.review,
            rating = entityRequest.rating,
            dateApproved = LocalDate.parse(entityRequest.dateApproved),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: StudentTestimony,
        entityRequest: StudentTestimonyDTOs.PutRequest
    ): StudentTestimony {
        return StudentTestimony(
            id = entity.id,
            studentCompaniesAttendedId = entityRequest.studentCompaniesAttendedId ?: entity.studentCompaniesAttendedId,
            review = entityRequest.review ?: entity.review,
            rating = entityRequest.rating ?: entity.rating,
            dateApproved = LocalDate.parse(entityRequest.dateApproved ?: entity.dateApproved.toString()),
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}
