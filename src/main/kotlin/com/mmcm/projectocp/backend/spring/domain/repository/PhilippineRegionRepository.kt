package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineRegion
import org.springframework.data.jpa.repository.JpaRepository

interface PhilippineRegionRepository : JpaRepository<PhilippineRegion, String> {
    // You can add custom query methods here if needed
}
