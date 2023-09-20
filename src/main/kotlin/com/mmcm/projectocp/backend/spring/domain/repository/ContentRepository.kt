package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Content
import org.springframework.data.jpa.repository.JpaRepository

interface ContentRepository : JpaRepository<Content, String> {
    // You can add custom query methods here if needed
}
