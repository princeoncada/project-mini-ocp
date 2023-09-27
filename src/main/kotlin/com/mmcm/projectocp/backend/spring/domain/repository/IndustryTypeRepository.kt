package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.IndustryType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IndustryTypeRepository: JpaRepository<IndustryType, String> {
    fun findById(id: String, pageable: Pageable): Page<IndustryType>
    fun findByType(type: String?): Optional<IndustryType>
}
