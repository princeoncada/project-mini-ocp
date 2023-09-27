package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.CompanyMapper
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyRepository
import com.mmcm.projectocp.backend.spring.domain.service.CompanyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyServiceImpl(
    private val companyRepository: CompanyRepository,
    private val companyMapper: CompanyMapper
): CompanyService {
    override fun getEntities(
        pageable: Pageable
    ): Page<CompanyDTOs.GetResult> {
        return companyRepository.findAll(pageable).map { companyMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyDTOs.GetResult> {
        val company = companyRepository.findById(id, pageable)
        return company.map { companyMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: CompanyDTOs.PostRequest,
        pageable: Pageable
    ): Page<CompanyDTOs.GetResult> {
        val companyId = UUID.randomUUID().toString()
        val savedCompany = companyRepository.save(companyMapper.createEntity(companyId, entityRequest))
        return companyRepository.findById(savedCompany.id, pageable).map { companyMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: CompanyDTOs.PutRequest,
        pageable: Pageable
    ): Page<CompanyDTOs.GetResult> {
        val currentCompany = companyRepository.findById(id).get()
        val savedCompany = companyRepository.save(companyMapper.updateEntity(currentCompany, entityRequest))
        return companyRepository.findById(savedCompany.id, pageable).map { companyMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyDTOs.GetResult> {
        val company = companyRepository.findById(id).get()
        companyRepository.delete(company)
        return companyRepository.findAll(pageable).map { companyMapper.toGetResult(it) }
    }
}