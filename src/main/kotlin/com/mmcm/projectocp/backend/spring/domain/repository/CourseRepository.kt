package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Course
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CourseRepository: JpaRepository<Course, String> {
    fun findById(id: String, pageable: Pageable): Page<Course>
    fun findByName(course: String?): Optional<Course>
}
