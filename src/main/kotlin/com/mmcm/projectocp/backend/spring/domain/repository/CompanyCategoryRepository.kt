package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.CompanyCategory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyCategoryRepository: JpaRepository<CompanyCategory, String> {
    fun findById(id: String, pageable: Pageable): Page<CompanyCategory>
    fun findByName(name: String?): Optional<CompanyCategory>
}
