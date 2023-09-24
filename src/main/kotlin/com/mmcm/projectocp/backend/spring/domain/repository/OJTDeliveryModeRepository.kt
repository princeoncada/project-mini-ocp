package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.OJTDeliveryMode
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OJTDeliveryModeRepository : JpaRepository<OJTDeliveryMode, String> {
    // You can add custom query methods here if needed

    fun findById(id: String, pageable: Pageable): Page<OJTDeliveryMode>
}
