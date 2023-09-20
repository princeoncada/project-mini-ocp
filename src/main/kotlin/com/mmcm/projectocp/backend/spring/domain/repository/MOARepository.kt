package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MOA
import org.springframework.data.jpa.repository.JpaRepository

interface MOARepository : JpaRepository<MOA, String> {
    // You can add custom query methods here if needed
}
