package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.CompanyContactPerson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyContactPersonRepository : JpaRepository<CompanyContactPerson, String> {
    // You can add custom query methods here if needed
}
