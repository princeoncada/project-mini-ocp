package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CompanyCategoryDTOs
import com.mmcm.projectocp.backend.spring.domain.model.CompanyCategory
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class CompanyCategoryMapper: EntityMapper<CompanyCategory, CompanyCategoryDTOs.GetResult, CompanyCategoryDTOs.PostRequest, CompanyCategoryDTOs.PutRequest> {
    override fun toGetResult(
        entity: CompanyCategory
    ): CompanyCategoryDTOs.GetResult {
        return CompanyCategoryDTOs.GetResult(
            id = entity.id,
            name = entity.name,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: CompanyCategoryDTOs.PostRequest
    ): CompanyCategory {
        return CompanyCategory(
            id = id,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: CompanyCategory,
        entityRequest: CompanyCategoryDTOs.PutRequest
    ): CompanyCategory {
        return CompanyCategory(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}