package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.StudentCourseDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.StudentCourseMapper
import com.mmcm.projectocp.backend.spring.domain.repository.StudentCourseRepository
import com.mmcm.projectocp.backend.spring.domain.service.StudentCourseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StudentCourseServiceImpl(
    private val studentCourseRepository: StudentCourseRepository,
    private val studentCourseMapper: StudentCourseMapper
): StudentCourseService {
    override fun getEntities(
        pageable: Pageable
    ): Page<StudentCourseDTOs.GetResult> {
        return studentCourseRepository.findAll(pageable).map { studentCourseMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<StudentCourseDTOs.GetResult> {
        val studentCourse = studentCourseRepository.findById(id, pageable)
        return studentCourse.map { studentCourseMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: StudentCourseDTOs.PostRequest,
        pageable: Pageable
    ): Page<StudentCourseDTOs.GetResult> {
        val studentCourseId = UUID.randomUUID().toString()
        val savedStudentCourse = studentCourseRepository.save(studentCourseMapper.createEntity(studentCourseId, entityRequest))
        return studentCourseRepository.findById(savedStudentCourse.id, pageable).map { studentCourseMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: StudentCourseDTOs.PutRequest,
        pageable: Pageable
    ): Page<StudentCourseDTOs.GetResult> {
        val studentCourse = studentCourseRepository.findById(id).get()
        val savedStudentCourse = studentCourseRepository.save(studentCourseMapper.updateEntity(studentCourse, entityRequest))
        return studentCourseRepository.findById(savedStudentCourse.id, pageable).map { studentCourseMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<StudentCourseDTOs.GetResult> {
        val studentCourse = studentCourseRepository.findById(id).get()
        studentCourseRepository.delete(studentCourse)
        return studentCourseRepository.findAll(pageable).map { studentCourseMapper.toGetResult(it) }
    }
}