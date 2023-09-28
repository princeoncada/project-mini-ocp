package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.CompanyBranch
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyBranchRepository: JpaRepository<CompanyBranch, String> {
    fun findById(id: String, pageable: Pageable): Page<CompanyBranch>
    fun findByName(name: String): Optional<CompanyBranch>
}
