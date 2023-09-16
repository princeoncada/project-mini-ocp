package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, String> {
    fun findByStudentId(studentId: String, pageable: Pageable): Page<User>
    fun findByEmailOrFirstNameOrLastName(
        firstName: String,
        lastName: String,
        email: String,
        pageable: Pageable
    ): Page<User>



}