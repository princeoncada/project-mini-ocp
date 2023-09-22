package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYearDTO
import org.springframework.stereotype.Service

@Service
interface AcademicYearService{
    fun createAcademicYear(req: AcademicYearDTO) : AcademicYearDTO
    fun updateAcademicYearById(id: String, req: AcademicYearDTO) : AcademicYearDTO
    fun deleteAcademicYearById(id: String)
}