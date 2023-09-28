package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyBranchDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.CompanyBranchMapper
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyBranchRepository
import com.mmcm.projectocp.backend.spring.domain.service.CompanyBranchService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyBranchServiceImpl(
    private val companyBranchRepository: CompanyBranchRepository,
    private val companyBranchMapper: CompanyBranchMapper
): CompanyBranchService {
    override fun getEntities(
        pageable: Pageable
    ): Page<CompanyBranchDTOs.GetResult> {
        return companyBranchRepository.findAll(pageable).map { companyBranchMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyBranchDTOs.GetResult> {
        val companyBranch = companyBranchRepository.findById(id, pageable)
        return companyBranch.map { companyBranchMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: CompanyBranchDTOs.PostRequest,
        pageable: Pageable
    ): Page<CompanyBranchDTOs.GetResult> {
        val companyBranchId = UUID.randomUUID().toString()
        val savedCompanyBranch = companyBranchRepository.save(companyBranchMapper.createEntity(companyBranchId, entityRequest))
        return companyBranchRepository.findById(savedCompanyBranch.id, pageable).map { companyBranchMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: CompanyBranchDTOs.PutRequest,
        pageable: Pageable
    ): Page<CompanyBranchDTOs.GetResult> {
        val companyBranch = companyBranchRepository.findById(id).get()
        val savedCompanyBranch = companyBranchMapper.updateEntity(companyBranch, entityRequest)
        return companyBranchRepository.findById(savedCompanyBranch.id, pageable).map { companyBranchMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyBranchDTOs.GetResult> {
        val companyBranch = companyBranchRepository.findById(id).get()
        companyBranchRepository.delete(companyBranch)
        return companyBranchRepository.findAll(pageable).map { companyBranchMapper.toGetResult(it) }
    }
}