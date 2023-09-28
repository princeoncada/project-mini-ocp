package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyContactPersonDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.CompanyContactPersonMapper
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyContactPersonRepository
import com.mmcm.projectocp.backend.spring.domain.service.CompanyContactPersonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyContactPersonServiceImpl(
    private val companyContactPersonRepository: CompanyContactPersonRepository,
    private val companyContactPersonMapper: CompanyContactPersonMapper
): CompanyContactPersonService {
    override fun getEntities(
        pageable: Pageable
    ): Page<CompanyContactPersonDTOs.GetResult> {
        return companyContactPersonRepository.findAll(pageable).map { companyContactPersonMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyContactPersonDTOs.GetResult> {
        val companyContactPerson = companyContactPersonRepository.findById(id, pageable)
        return companyContactPerson.map { companyContactPersonMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: CompanyContactPersonDTOs.PostRequest,
        pageable: Pageable
    ): Page<CompanyContactPersonDTOs.GetResult> {
        val companyContactPersonId = UUID.randomUUID().toString()
        val savedCompanyContactPerson = companyContactPersonRepository.save(companyContactPersonMapper.createEntity(companyContactPersonId, entityRequest))
        return companyContactPersonRepository.findById(savedCompanyContactPerson.id, pageable).map { companyContactPersonMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: CompanyContactPersonDTOs.PutRequest,
        pageable: Pageable
    ): Page<CompanyContactPersonDTOs.GetResult> {
        val currentCompanyContactPerson = companyContactPersonRepository.findById(id).get()
        val savedCompanyContactPerson = companyContactPersonRepository.save(companyContactPersonMapper.updateEntity(currentCompanyContactPerson, entityRequest))
        return companyContactPersonRepository.findById(savedCompanyContactPerson.id, pageable).map { companyContactPersonMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<CompanyContactPersonDTOs.GetResult> {
        val companyContactPerson = companyContactPersonRepository.findById(id).get()
        companyContactPersonRepository.delete(companyContactPerson)
        return companyContactPersonRepository.findAll(pageable).map { companyContactPersonMapper.toGetResult(it) }
    }
}