package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.IndustryType
import org.springframework.data.jpa.repository.JpaRepository

interface IndustryTypeRepository : JpaRepository<IndustryType, String> {
    // You can add custom query methods here if needed
}
