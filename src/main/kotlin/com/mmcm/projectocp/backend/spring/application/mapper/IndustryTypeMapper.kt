package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.IndustryTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.IndustryType
import com.mmcm.projectocp.backend.spring.domain.repository.IndustryTypeRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class IndustryTypeMapper(
) : EntityMapper<IndustryType, IndustryTypeDTOs.GetResult, IndustryTypeDTOs.PostRequest, IndustryTypeDTOs.PutRequest>{
    override fun toGetResult(entity: IndustryType): IndustryTypeDTOs.GetResult {
        return IndustryTypeDTOs.GetResult(
            id = entity.id,
            type = entity.type
        )
    }

    override fun createEntity(id: String, entityRequest: IndustryTypeDTOs.PostRequest): IndustryType {
        return IndustryType(
            id = id,
            type = entityRequest.type,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(entity: IndustryType, entityRequest: IndustryTypeDTOs.PutRequest): IndustryType {
        return IndustryType(
            id = entity.id,
            type = entityRequest.type ?: entity.type,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }


}