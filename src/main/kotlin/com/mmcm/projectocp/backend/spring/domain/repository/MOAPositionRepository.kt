package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MOAPosition
import org.springframework.data.jpa.repository.JpaRepository

interface MOAPositionRepository : JpaRepository<MOAPosition, String> {
    // You can add custom query methods here if needed
}
