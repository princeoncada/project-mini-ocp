package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MCStatus
import org.springframework.data.jpa.repository.JpaRepository

interface MCStatusRepository : JpaRepository<MCStatus, String> {
    // You can add custom query methods here if needed
}
