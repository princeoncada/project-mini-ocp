package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.CompanyCategory
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyCategoryRepository : JpaRepository<CompanyCategory, String> {
    // You can add custom query methods here if needed
}