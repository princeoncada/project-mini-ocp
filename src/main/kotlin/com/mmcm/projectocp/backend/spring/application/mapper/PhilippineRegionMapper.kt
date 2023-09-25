package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineRegionDTOs
import com.mmcm.projectocp.backend.spring.domain.model.PhilippineRegion
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class PhilippineRegionMapper: EntityMapper<PhilippineRegion ,PhilippineRegionDTOs.GetResult, PhilippineRegionDTOs.PostRequest, PhilippineRegionDTOs.PutRequest>{
    override fun toGetResult(
        entity: PhilippineRegion
    ): PhilippineRegionDTOs.GetResult {
        return PhilippineRegionDTOs.GetResult(
            id = entity.id,
            regionCode = entity.regionCode,
            name = entity.name,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: PhilippineRegionDTOs.PostRequest
    ): PhilippineRegion {
        return PhilippineRegion(
            id = id,
            regionCode = entityRequest.regionCode,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: PhilippineRegion,
        entityRequest: PhilippineRegionDTOs.PutRequest
    ): PhilippineRegion {
        return PhilippineRegion(
            id = entity.id,
            regionCode = entityRequest.regionCode ?: entity.regionCode,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}