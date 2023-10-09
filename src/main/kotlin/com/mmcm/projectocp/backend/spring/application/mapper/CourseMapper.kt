package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CourseDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Course
import com.mmcm.projectocp.backend.spring.domain.repository.AcademicYearRepository
import com.mmcm.projectocp.backend.spring.domain.repository.TermRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class CourseMapper(
    private val academicYearRepository: AcademicYearRepository,
    private val termRepository: TermRepository,
    private val userRepository: UserRepository
): EntityMapper<Course, CourseDTOs.GetResult, CourseDTOs.PostRequest, CourseDTOs.PutRequest> {
    override fun toGetResult(
        entity: Course
    ): CourseDTOs.GetResult {
        return CourseDTOs.GetResult(
            id = entity.id,
            yearTo = entity.academicYear.yearTo,
            yearFrom = entity.academicYear.yearFrom,
            term = entity.term.code,
            name = entity.name,
            code = entity.code,
            instructor = entity.instructor?.email,
            isActive = entity.isActive
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: CourseDTOs.PostRequest
    ): Course {
        return Course(
            id = id,
            academicYear = academicYearRepository.findByYearToAndYearFrom(entityRequest.yearTo, entityRequest.yearFrom).get(),
            term = termRepository.findByCode(entityRequest.term).get(),
            name = entityRequest.name,
            code = entityRequest.code,
            instructor = userRepository.findByEmail(entityRequest.instructor).get(),
            isActive = entityRequest.isActive,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Course,
        entityRequest: CourseDTOs.PutRequest
    ): Course {
        return Course(
            id = entity.id,
            academicYear = academicYearRepository.findByYearToAndYearFrom(entityRequest.yearTo, entityRequest.yearFrom).getOrNull() ?: entity.academicYear,
            term = termRepository.findByCode(entityRequest.term).getOrNull() ?: entity.term,
            name = entityRequest.name ?: entity.name,
            code = entityRequest.code ?: entity.code,
            instructor = userRepository.findByEmail(entityRequest.instructor).getOrNull() ?: entity.instructor,
            isActive = entityRequest.isActive ?: entity.isActive,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}