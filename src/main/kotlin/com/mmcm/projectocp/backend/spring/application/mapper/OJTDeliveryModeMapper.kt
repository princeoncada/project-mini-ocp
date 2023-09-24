package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.OJTDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.OJTDeliveryMode
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class OJTDeliveryModeMapper: EntityMapper<OJTDeliveryMode, OJTDeliveryModeDTOs.GetResult, OJTDeliveryModeDTOs.PostRequest, OJTDeliveryModeDTOs.PutRequest> {
    override fun toGetResult(entity: OJTDeliveryMode): OJTDeliveryModeDTOs.GetResult {
        return OJTDeliveryModeDTOs.GetResult(
            id = entity.id,
            mode = entity.mode,
        )
    }

    override fun createEntity(id: String, entityRequest: OJTDeliveryModeDTOs.PostRequest): OJTDeliveryMode {
        return OJTDeliveryMode(
            id = id,
            mode = entityRequest.mode,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(entity: OJTDeliveryMode, entityRequest: OJTDeliveryModeDTOs.PutRequest): OJTDeliveryMode {
        return OJTDeliveryMode(
            id = entity.id,
            mode = entityRequest.mode ?: entity.mode,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}
