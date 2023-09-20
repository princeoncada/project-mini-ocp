package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PartnershipType
import org.springframework.data.jpa.repository.JpaRepository

interface PartnershipTypeRepository : JpaRepository<PartnershipType, String> {
    // You can add custom query methods here if needed
}