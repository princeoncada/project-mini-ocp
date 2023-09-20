package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.File
import org.springframework.data.jpa.repository.JpaRepository

interface FileRepository : JpaRepository<File, String> {
    // You can add custom query methods here if needed
}
