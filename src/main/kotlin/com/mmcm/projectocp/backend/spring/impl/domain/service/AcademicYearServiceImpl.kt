package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYeartDto
import com.mmcm.projectocp.backend.spring.application.mapper.AcademicYearMapper
import com.mmcm.projectocp.backend.spring.domain.repository.AcademicYearRepository
import com.mmcm.projectocp.backend.spring.domain.service.AcademicYearService
import org.springframework.stereotype.Service

@Service
class AcademicYearServiceImpl(
    private val academicYearRepository: AcademicYearRepository,
    private val academicYearMapper: AcademicYearMapper
): AcademicYearService {

    override fun createAcademicYear(req: AcademicYeartDto): AcademicYeartDto {
        val academicYearEntity = academicYearMapper.toEntity(req)
        val academicYearEntityCreated = academicYearRepository.save(academicYearEntity)
        return academicYearMapper.toDto(academicYearEntityCreated)
    }

    override fun updateAcademicYearById(id: String, req: AcademicYeartDto): AcademicYeartDto {
        val academicYearEntity = academicYearMapper.toEntity(req)
        val academicYearEntityUpdated = academicYearRepository.save(academicYearEntity)
        return academicYearMapper.toDto(academicYearEntityUpdated)
    }

    override fun deleteAcademicYearById(id: String) {
        academicYearRepository.deleteById(id)
    }
}