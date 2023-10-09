package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.StudentCourseDTOs
import com.mmcm.projectocp.backend.spring.domain.model.StudentCourse
import com.mmcm.projectocp.backend.spring.domain.repository.CourseRepository
import com.mmcm.projectocp.backend.spring.domain.repository.ProgramRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class StudentCourseMapper(
    private val programRepository: ProgramRepository,
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository
): EntityMapper<StudentCourse, StudentCourseDTOs.GetResult, StudentCourseDTOs.PostRequest, StudentCourseDTOs.PutRequest> {
    override fun toGetResult(
        entity: StudentCourse
    ): StudentCourseDTOs.GetResult {
        return StudentCourseDTOs.GetResult(
            id = entity.id,
            course = entity.course.name,
            user = entity.user?.email,
            adviser = entity.adviser?.email,
            program = entity.program.name,
            email = entity.email,
            studentId = entity.studentId,
            isFinished = entity.isFinished,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: StudentCourseDTOs.PostRequest
    ): StudentCourse {
        return StudentCourse(
            id = id,
            course = courseRepository.findByName(entityRequest.course).get(),
            user = userRepository.findByEmail(entityRequest.user).get(),
            adviser = userRepository.findByEmail(entityRequest.adviser).get(),
            program = programRepository.findByName(entityRequest.program).get(),
            email = entityRequest.email,
            studentId = entityRequest.studentId,
            isFinished = entityRequest.isFinished,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: StudentCourse,
        entityRequest: StudentCourseDTOs.PutRequest
    ): StudentCourse {
        return StudentCourse(
            id = entity.id,
            course = courseRepository.findByName(entityRequest.course).getOrNull() ?: entity.course,
            user = userRepository.findByEmail(entityRequest.user).getOrNull() ?: entity.user,
            adviser = userRepository.findByEmail(entityRequest.adviser).getOrNull() ?: entity.adviser,
            program = programRepository.findByName(entityRequest.program).getOrNull() ?: entity.program,
            email = entityRequest.email ?: entity.email,
            studentId = entityRequest.studentId ?: entity.studentId,
            isFinished = entityRequest.isFinished ?: entity.isFinished,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}
