package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Course
import com.mmcm.projectocp.backend.spring.domain.model.StudentCourse
import com.mmcm.projectocp.backend.spring.domain.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface StudentCourseRepository: JpaRepository<StudentCourse, String> {
    fun findById(id: String, pageable: Pageable): Page<StudentCourse>
    fun findByUser(user: User?): Optional<StudentCourse>
}
