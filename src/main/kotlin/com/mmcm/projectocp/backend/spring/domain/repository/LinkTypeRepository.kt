package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.LinkType
import org.springframework.data.jpa.repository.JpaRepository

interface LinkTypeRepository : JpaRepository<LinkType, String> {
    // You can add custom query methods here if needed
}
