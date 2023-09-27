package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineProvinceDTOs
import com.mmcm.projectocp.backend.spring.domain.model.PhilippineProvince
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class PhilippineProvinceMapper: EntityMapper<PhilippineProvince, PhilippineProvinceDTOs.GetResult, PhilippineProvinceDTOs.PostRequest, PhilippineProvinceDTOs.PutRequest> {
    override fun toGetResult(
        entity: PhilippineProvince
    ): PhilippineProvinceDTOs.GetResult {
        return PhilippineProvinceDTOs.GetResult(
            id = entity.id,
            provCode = entity.provinceCode,
            regCode = entity.regionCode,
            name = entity.name
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: PhilippineProvinceDTOs.PostRequest
    ): PhilippineProvince {
        return PhilippineProvince(
            id = id,
            provinceCode = entityRequest.provCode,
            regionCode = entityRequest.regCode,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: PhilippineProvince,
        entityRequest: PhilippineProvinceDTOs.PutRequest
    ): PhilippineProvince {
        return PhilippineProvince(
            id = entity.id,
            provinceCode = entityRequest.provCode ?: entity.provinceCode,
            regionCode = entityRequest.regCode ?: entity.regionCode,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}