package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Department
import com.mmcm.projectocp.backend.spring.domain.model.Program
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProgramRepository: JpaRepository<Program, String> {
    fun findById(id: String, pageable: Pageable): Page<Program>
    fun findByName(name: String?): Optional<Program>
}
