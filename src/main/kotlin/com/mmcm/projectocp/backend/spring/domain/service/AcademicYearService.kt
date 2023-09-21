package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYeartDto
import org.springframework.stereotype.Service

@Service
interface AcademicYearService{
    fun createAcademicYear(req: AcademicYeartDto) : AcademicYeartDto
    fun updateAcademicYearById(id: String, req: AcademicYeartDto) : AcademicYeartDto
    fun deleteAcademicYearById(id: String)
}