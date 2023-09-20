package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MOAPartnershipType
import org.springframework.data.jpa.repository.JpaRepository

interface MOAPartnershipTypeRepository : JpaRepository<MOAPartnershipType, String> {
    // You can add custom query methods here if needed
}
