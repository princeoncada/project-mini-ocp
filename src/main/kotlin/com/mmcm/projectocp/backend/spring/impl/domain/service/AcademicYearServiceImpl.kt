package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYearDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.AcademicYearMapper
import com.mmcm.projectocp.backend.spring.domain.repository.AcademicYearRepository
import com.mmcm.projectocp.backend.spring.domain.service.AcademicYearService
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class AcademicYearServiceImpl(
    private val academicYearRepository: AcademicYearRepository,
    private val academicYearMapper: AcademicYearMapper
): AcademicYearService {
    override fun getEntities(
        pageable: Pageable
    ): Page<AcademicYearDTOs.GetResult> {
        return academicYearRepository.findAll(pageable).map { academicYearMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<AcademicYearDTOs.GetResult> {
        val academic = academicYearRepository.findById(id, pageable)
        return academic.map { academicYearMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: AcademicYearDTOs.PostRequest,
        pageable: Pageable
    ): Page<AcademicYearDTOs.GetResult> {
        val academicId = UUID.randomUUID().toString()
        val savedAcademicYear = academicYearRepository.save(academicYearMapper.createEntity(academicId, entityRequest))
        return academicYearRepository.findById(savedAcademicYear.id, pageable).map { academicYearMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: AcademicYearDTOs.PutRequest,
        pageable: Pageable
    ): Page<AcademicYearDTOs.GetResult> {
        val currentAcademic = academicYearRepository.findById(id).get()
        val savedAcademicYear = academicYearRepository.save(academicYearMapper.updateEntity(currentAcademic, entityRequest))
        return academicYearRepository.findById(savedAcademicYear.id, pageable).map { academicYearMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<AcademicYearDTOs.GetResult> {
        val academic = academicYearRepository.findById(id).get()
        academicYearRepository.delete(academic)
        return academicYearRepository.findAll(pageable).map { academicYearMapper.toGetResult(it) }
    }
}