package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYearDTOs
import com.mmcm.projectocp.backend.spring.domain.model.AcademicYear
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class AcademicYearMapper: EntityMapper<AcademicYear, AcademicYearDTOs.GetResult, AcademicYearDTOs.PostRequest, AcademicYearDTOs.PutRequest> {
    override fun toGetResult(
        entity: AcademicYear
    ): AcademicYearDTOs.GetResult {
        return AcademicYearDTOs.GetResult(
            id = entity.id,
            yearFrom = entity.yearFrom,
            yearTo = entity.yearTo
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: AcademicYearDTOs.PostRequest
    ): AcademicYear {
        return AcademicYear(
            id = id,
            yearFrom = entityRequest.yearFrom,
            yearTo = entityRequest.yearTo,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: AcademicYear,
        entityRequest: AcademicYearDTOs.PutRequest
    ): AcademicYear {
        return AcademicYear(
            id = entity.id,
            yearFrom = entityRequest.yearFrom?: entity.yearFrom,
            yearTo = entityRequest.yearTo?: entity.yearTo,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}
