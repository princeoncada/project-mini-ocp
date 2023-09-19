package com.mmcm.projectocp.backend.spring.domain.repository;

import com.mmcm.projectocp.backend.spring.domain.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoleRepository : JpaRepository<Role, String> {

    fun findByName(role: String): Role
}