package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.McStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface McStatusRepository: JpaRepository<McStatus, String> {
    fun findById(id: String, pageable: Pageable): Page<McStatus>
    fun findByName(name: String?): Optional<McStatus>
}
