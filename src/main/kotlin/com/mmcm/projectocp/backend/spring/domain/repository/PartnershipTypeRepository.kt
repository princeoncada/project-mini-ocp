package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PartnershipType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnershipTypeRepository: JpaRepository<PartnershipType, String> {
    fun findById(id: String, pageable: Pageable): Page<PartnershipType>
    fun findByType(type: String?): Optional<PartnershipType>
}