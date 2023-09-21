package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineRegion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PhilippineRegionRepository : JpaRepository<PhilippineRegion, String> {
    // You can add custom query methods here if needed


    fun findByRegionCode(regionCode: String): Optional<PhilippineRegion>
}
