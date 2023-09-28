package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionDTOs
import com.mmcm.projectocp.backend.spring.domain.model.MoaPosition
import com.mmcm.projectocp.backend.spring.domain.repository.AcademicYearRepository
import com.mmcm.projectocp.backend.spring.domain.repository.MoaRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class MoaPositionMapper(
    private val moaRepository: MoaRepository,
    private val academicYearRepository: AcademicYearRepository
): EntityMapper<MoaPosition, MoaPositionDTOs.GetResult, MoaPositionDTOs.PostRequest, MoaPositionDTOs.PutRequest> {
    override fun toGetResult(
        entity: MoaPosition
    ): MoaPositionDTOs.GetResult {
        return MoaPositionDTOs.GetResult(
            id = entity.id,
            moa = entity.moa.title,
            yearTo = entity.academicYear?.yearTo,
            yearFrom = entity.academicYear?.yearFrom,
            name = entity.name,
            requirements = entity.requirements,
            studentsAccommodated = entity.studentsAccommodated,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MoaPositionDTOs.PostRequest
    ): MoaPosition {
        return MoaPosition(
            id = id,
            moa = moaRepository.findByTitle(entityRequest.moa).get(),
            academicYear = academicYearRepository.findByYearToAndYearFrom(entityRequest.yearTo, entityRequest.yearFrom).getOrNull(),
            name = entityRequest.name,
            requirements = entityRequest.requirements,
            studentsAccommodated = entityRequest.studentsAccommodated,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: MoaPosition,
        entityRequest: MoaPositionDTOs.PutRequest
    ): MoaPosition {
        return MoaPosition(
            id = entity.id,
            moa = moaRepository.findByTitle(entityRequest.moa ?: entity.moa.title).get(),
            academicYear = academicYearRepository.findByYearToAndYearFrom(entityRequest.yearTo, entityRequest.yearFrom).getOrNull()
                ?: academicYearRepository.findByYearToAndYearFrom(entity.academicYear?.yearTo, entity.academicYear?.yearFrom).getOrNull(),
            name = entityRequest.name ?: entity.name,
            requirements = entityRequest.requirements ?: entity.requirements,
            studentsAccommodated = entityRequest.studentsAccommodated ?: entity.studentsAccommodated,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}