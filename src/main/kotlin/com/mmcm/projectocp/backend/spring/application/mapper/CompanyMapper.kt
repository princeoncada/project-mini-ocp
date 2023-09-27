package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CompanyDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Company
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyCategoryRepository
import com.mmcm.projectocp.backend.spring.domain.repository.IndustryTypeRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class CompanyMapper(
    private val companyCategoryRepository: CompanyCategoryRepository,
    private val industryTypeRepository: IndustryTypeRepository
): EntityMapper<Company, CompanyDTOs.GetResult, CompanyDTOs.PostRequest, CompanyDTOs.PutRequest> {
    override fun toGetResult(
        entity: Company
    ): CompanyDTOs.GetResult {
        return CompanyDTOs.GetResult(
            id = entity.id,
            name = entity.name,
            companyCategory = entity.companyCategory.name,
            industryType = entity.industryType.type,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: CompanyDTOs.PostRequest
    ): Company {
        return Company(
            id = id,
            name = entityRequest.name,
            companyCategory = companyCategoryRepository.findByName(entityRequest.companyCategory).get(),
            industryType = industryTypeRepository.findByType(entityRequest.industryType).get(),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Company,
        entityRequest: CompanyDTOs.PutRequest
    ): Company {
        return Company(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            companyCategory = companyCategoryRepository.findByName(entityRequest.companyCategory
                ?: entity.companyCategory.name).get(),
            industryType = industryTypeRepository.findByType(entityRequest.industryType
                ?: entity.industryType.type).get(),
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}