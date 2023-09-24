package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineProvince
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PhilippineProvinceRepository : JpaRepository<PhilippineProvince, String> {
    // You can add custom query methods here if needed
    fun findByProvinceCode(provcode: String): Optional<PhilippineProvince>
}
