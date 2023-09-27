package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineBarangay
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhilippineBarangayRepository: JpaRepository<PhilippineBarangay, String> {
    fun findById(id: String, pageable: Pageable): Page<PhilippineBarangay>
}
