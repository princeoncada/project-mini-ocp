package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.OjtDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.OjtDeliveryMode
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class OjtDeliveryModeMapper: EntityMapper<OjtDeliveryMode, OjtDeliveryModeDTOs.GetResult, OjtDeliveryModeDTOs.PostRequest, OjtDeliveryModeDTOs.PutRequest> {
    override fun toGetResult(
        entity: OjtDeliveryMode
    ): OjtDeliveryModeDTOs.GetResult {
        return OjtDeliveryModeDTOs.GetResult(
            id = entity.id,
            mode = entity.mode,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: OjtDeliveryModeDTOs.PostRequest
    ): OjtDeliveryMode {
        return OjtDeliveryMode(
            id = id,
            mode = entityRequest.mode,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: OjtDeliveryMode,
        entityRequest: OjtDeliveryModeDTOs.PutRequest
    ): OjtDeliveryMode {
        return OjtDeliveryMode(
            id = entity.id,
            mode = entityRequest.mode ?: entity.mode,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}