package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRoleRepository: JpaRepository<UserRole, String> {
    fun findById(id: String, pageable: Pageable): Page<UserRole>
    fun findByUserId(userId: String): UserRole
    fun existsByUserId(userId: String): Boolean
}