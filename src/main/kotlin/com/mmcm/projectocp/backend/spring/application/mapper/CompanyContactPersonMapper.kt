package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CompanyContactPersonDTOs
import com.mmcm.projectocp.backend.spring.domain.model.CompanyContactPerson
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class CompanyContactPersonMapper(
    private val companyRepository: CompanyRepository
): EntityMapper<CompanyContactPerson, CompanyContactPersonDTOs.GetResult, CompanyContactPersonDTOs.PostRequest, CompanyContactPersonDTOs.PutRequest> {
    override fun toGetResult(
        entity: CompanyContactPerson
    ): CompanyContactPersonDTOs.GetResult {
        return CompanyContactPersonDTOs.GetResult(
            id = entity.id,
            company = entity.company.name,
            name = entity.name,
            designation = entity.designation,
            email = entity.email,
            phone = entity.phone,
            isActive = entity.isActive,
            createdAt = entity.createdAt.toString(),
            updatedAt = entity.updatedAt.toString()
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: CompanyContactPersonDTOs.PostRequest
    ): CompanyContactPerson {
        return CompanyContactPerson(
            id = id,
            company = companyRepository.findByName(entityRequest.company).get(),
            name = entityRequest.name,
            designation = entityRequest.designation,
            email = entityRequest.email,
            phone = entityRequest.phone,
            isActive = entityRequest.isActive,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: CompanyContactPerson,
        entityRequest: CompanyContactPersonDTOs.PutRequest
    ): CompanyContactPerson {
        return CompanyContactPerson(
            id = entity.id,
            company = companyRepository.findByName(entityRequest.company ?: entity.company.name).get(),
            name = entityRequest.name ?: entity.name,
            designation = entityRequest.designation ?: entity.designation,
            email = entityRequest.email ?: entity.email,
            phone = entityRequest.phone ?: entity.phone,
            isActive = entityRequest.isActive ?: entity.isActive,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}