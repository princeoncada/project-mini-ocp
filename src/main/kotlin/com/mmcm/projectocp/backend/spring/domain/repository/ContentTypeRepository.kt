package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.ContentType
import org.springframework.data.jpa.repository.JpaRepository

interface ContentTypeRepository : JpaRepository<ContentType, String> {
    // You can add custom query methods here if needed
}
