package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CourseDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.CourseMapper
import com.mmcm.projectocp.backend.spring.domain.repository.CourseRepository
import com.mmcm.projectocp.backend.spring.domain.service.CourseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CourseServiceImpl(
    private val courseRepository: CourseRepository,
    private val courseMapper: CourseMapper
): CourseService {
    override fun getEntities(
        pageable: Pageable
    ): Page<CourseDTOs.GetResult> {
        return courseRepository.findAll(pageable).map { courseMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<CourseDTOs.GetResult> {
        val course = courseRepository.findById(id, pageable)
        return course.map { courseMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: CourseDTOs.PostRequest,
        pageable: Pageable
    ): Page<CourseDTOs.GetResult> {
        val courseId = UUID.randomUUID().toString()
        val savedCourse = courseRepository.save(courseMapper.createEntity(courseId, entityRequest))
        return courseRepository.findById(savedCourse.id, pageable).map { courseMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: CourseDTOs.PutRequest,
        pageable: Pageable
    ): Page<CourseDTOs.GetResult> {
        val course = courseRepository.findById(id).get()
        val savedCourse = courseRepository.save(courseMapper.updateEntity(course, entityRequest))
        return courseRepository.findById(savedCourse.id, pageable).map { courseMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<CourseDTOs.GetResult> {
        val course = courseRepository.findById(id).get()
        courseRepository.delete(course)
        return courseRepository.findAll(pageable).map { courseMapper.toGetResult(it) }
    }
}