package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Term
import org.springframework.data.jpa.repository.JpaRepository

interface TermRepository : JpaRepository<Term, String> {
    // You can add custom query methods here if needed
}
