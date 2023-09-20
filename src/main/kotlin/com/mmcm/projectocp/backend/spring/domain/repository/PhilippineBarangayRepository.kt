package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineBarangay
import org.springframework.data.jpa.repository.JpaRepository

interface PhilippineBarangayRepository : JpaRepository<PhilippineBarangay, String> {
    // You can add custom query methods here if needed
}
