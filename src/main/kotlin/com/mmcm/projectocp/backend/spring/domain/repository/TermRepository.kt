package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Term
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TermRepository: JpaRepository<Term, String> {
    fun findById(id: String, pageable: Pageable): Page<Term>
    fun findByCode(code: String?): Optional<Term>
}
