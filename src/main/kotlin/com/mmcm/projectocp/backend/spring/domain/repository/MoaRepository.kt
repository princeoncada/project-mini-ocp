package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Moa
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MoaRepository: JpaRepository<Moa, String> {
    fun findById(id: String, pageable: Pageable): Page<Moa>
    fun findByTitle(title: String?): Optional<Moa>
}
