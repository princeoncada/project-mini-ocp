package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Requirement
import org.springframework.data.jpa.repository.JpaRepository

interface RequirementRepository : JpaRepository<Requirement, String> {
    // You can add custom query methods here if needed
}
