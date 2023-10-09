package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.StudentCompanyAttendanceDTOs
import com.mmcm.projectocp.backend.spring.domain.model.StudentCompanyAttendance
import com.mmcm.projectocp.backend.spring.domain.repository.MoaRepository
import com.mmcm.projectocp.backend.spring.domain.repository.StudentCourseRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDate
import kotlin.jvm.optionals.getOrNull

@Component
class StudentCompanyAttendanceMapper(
    private val studentCourseRepository: StudentCourseRepository,
    private val userRepository: UserRepository,
    private val moaRepository: MoaRepository
): EntityMapper<StudentCompanyAttendance, StudentCompanyAttendanceDTOs.GetResult, StudentCompanyAttendanceDTOs.PostRequest, StudentCompanyAttendanceDTOs.PutRequest> {
    override fun toGetResult(
        entity: StudentCompanyAttendance
    ): StudentCompanyAttendanceDTOs.GetResult {
        return StudentCompanyAttendanceDTOs.GetResult(
            id = entity.id,
            studentCourse = entity.studentCourse.course.name,
            moa = entity.moa.title,
            designation = entity.designation,
            hours = entity.hours,
            dateStart = entity.dateStart.toString(),
            dateEnd = entity.dateEnd?.toString(),
            finishedAt = entity.finishedAt?.toString(),
            cancelledAt = entity.cancelledAt?.toString()
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: StudentCompanyAttendanceDTOs.PostRequest
    ): StudentCompanyAttendance {
        return StudentCompanyAttendance(
            id = id,
            studentCourse = studentCourseRepository.findByUser(userRepository.findByEmail(entityRequest.studentCourse).get()).get(),
            moa = moaRepository.findByTitle(entityRequest.moa).get(),
            designation = entityRequest.designation,
            hours = entityRequest.hours,
            dateStart = LocalDate.parse(entityRequest.dateStart),
            dateEnd = LocalDate.parse(entityRequest.dateEnd),
            finishedAt = LocalDate.parse(entityRequest.finishedAt),
            cancelledAt = LocalDate.parse(entityRequest.cancelledAt),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: StudentCompanyAttendance,
        entityRequest: StudentCompanyAttendanceDTOs.PutRequest
    ): StudentCompanyAttendance {
        return StudentCompanyAttendance(
            id = entity.id,
            studentCourse = studentCourseRepository.findByUser(userRepository.findByEmail(entityRequest.studentCourse).getOrNull()).getOrNull() ?: entity.studentCourse,
            moa = moaRepository.findByTitle(entityRequest.moa).getOrNull() ?: entity.moa,
            designation = entityRequest.designation ?: entity.designation,
            hours = entityRequest.hours ?: entity.hours,
            dateStart = LocalDate.parse(entityRequest.dateStart) ?: entity.dateStart,
            dateEnd = LocalDate.parse(entityRequest.dateEnd) ?: entity.dateEnd,
            finishedAt = LocalDate.parse(entityRequest.finishedAt) ?: entity.finishedAt,
            cancelledAt = LocalDate.parse(entityRequest.cancelledAt) ?: entity.cancelledAt,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}