package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.AcademicYear
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AcademicYearRepository : JpaRepository<AcademicYear, String> {
    // You can add custom query methods here if needed

    fun findByYearTo(yearTo: Int, pageable: Pageable): Optional<Page<AcademicYear>>

    fun findByYearFrom(yearFrom: Int, pageable: Pageable): Optional<Page<AcademicYear>>

    fun findByYearFromAndYearTo(yearFrom: Int, yearTo: Int, pageable: Pageable): Optional<Page<AcademicYear>>

    fun findByYearFromLessThanEqualAndYearToGreaterThanEqual(yearFrom: Int, yearTo: Int, pageable: Pageable): Optional<Page<AcademicYear>>



}
