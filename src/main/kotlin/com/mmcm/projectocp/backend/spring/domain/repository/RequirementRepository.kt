package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Requirement
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RequirementRepository: JpaRepository<Requirement, String> {
    fun findById(id: String, pageable: Pageable): Page<Requirement>
    fun findByTitle(title: String?): Optional<Requirement>
}
