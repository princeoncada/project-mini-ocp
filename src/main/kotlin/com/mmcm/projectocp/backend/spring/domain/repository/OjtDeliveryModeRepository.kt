package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.OjtDeliveryMode
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OjtDeliveryModeRepository: JpaRepository<OjtDeliveryMode, String> {
    fun findById(id: String, pageable: Pageable): Page<OjtDeliveryMode>
    fun findByMode(mode: String?): Optional<OjtDeliveryMode>
}