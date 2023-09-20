package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.FileType
import org.springframework.data.jpa.repository.JpaRepository

interface FileTypeRepository : JpaRepository<FileType, String> {
    // You can add custom query methods here if needed
}