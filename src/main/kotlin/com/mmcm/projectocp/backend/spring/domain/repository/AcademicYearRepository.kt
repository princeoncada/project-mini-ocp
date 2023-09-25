package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.AcademicYear
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AcademicYearRepository: JpaRepository<AcademicYear, String> {
    fun findById(id: String, pageable: Pageable): Page<AcademicYear>
}
