package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.UserEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface UserRepository : JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {
    fun findByStudentId(studentId: String, pageable: Pageable): Page<UserEntity>
    fun findByEmailOrFirstNameOrLastName(
        firstName: String,
        lastName: String,
        email: String,
        pageable: Pageable
    ): Page<UserEntity>

    fun findUsersByRolesName(name: String, pageable: Pageable): Page<UserEntity>


    fun existsByEmailAndStudentId(email: String, studentId: String): Boolean


    fun existsByEmail(email: String): Boolean


    fun findByEmail(email: String): Optional<UserEntity>
}