package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyCategoryDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.CompanyCategoryMapper
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyCategoryRepository
import com.mmcm.projectocp.backend.spring.domain.service.CompanyCategoryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyCategoryServiceImpl(
    private val companyCategoryRepository: CompanyCategoryRepository,
    private val companyCategoryMapper: CompanyCategoryMapper
): CompanyCategoryService {
    override fun getEntities(
        pageable: Pageable
    ): Page<CompanyCategoryDTOs.GetResult> {
        return companyCategoryRepository.findAll(pageable).map { companyCategoryMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyCategoryDTOs.GetResult> {
        val companyCategory = companyCategoryRepository.findById(id, pageable)
        return companyCategory.map { companyCategoryMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: CompanyCategoryDTOs.PostRequest,
        pageable: Pageable
    ): Page<CompanyCategoryDTOs.GetResult> {
        val companyCategoryId = UUID.randomUUID().toString()
        val savedCompanyCategory = companyCategoryRepository.save(companyCategoryMapper.createEntity(companyCategoryId, entityRequest))
        return companyCategoryRepository.findById(savedCompanyCategory.id, pageable).map { companyCategoryMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: CompanyCategoryDTOs.PutRequest,
        pageable: Pageable
    ): Page<CompanyCategoryDTOs.GetResult> {
        val currentCompanyCategory = companyCategoryRepository.findById(id).get()
        val savedCompanyCategory = companyCategoryRepository.save(companyCategoryMapper.updateEntity(currentCompanyCategory, entityRequest))
        return companyCategoryRepository.findById(savedCompanyCategory.id, pageable).map { companyCategoryMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyCategoryDTOs.GetResult> {
        val companyCategory = companyCategoryRepository.findById(id).get()
        companyCategoryRepository.delete(companyCategory)
        return companyCategoryRepository.findAll(pageable).map { companyCategoryMapper.toGetResult(it) }
    }
}