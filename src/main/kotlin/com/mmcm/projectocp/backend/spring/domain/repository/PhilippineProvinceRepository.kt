package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineProvince
import org.springframework.data.jpa.repository.JpaRepository

interface PhilippineProvinceRepository : JpaRepository<PhilippineProvince, String> {
    // You can add custom query methods here if needed
}
