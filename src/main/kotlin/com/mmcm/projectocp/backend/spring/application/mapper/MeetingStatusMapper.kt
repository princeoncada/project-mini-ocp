package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MeetingStatusDTOs
import com.mmcm.projectocp.backend.spring.domain.model.MeetingStatus
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class MeetingStatusMapper : EntityMapper<MeetingStatus, MeetingStatusDTOs.GetResult, MeetingStatusDTOs.PostRequest, MeetingStatusDTOs.PutRequest> {
    override fun toGetResult(
        entity: MeetingStatus
    ): MeetingStatusDTOs.GetResult {
        return MeetingStatusDTOs.GetResult(
            id = entity.id,
            name = entity.name
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MeetingStatusDTOs.PostRequest
    ): MeetingStatus {
        return MeetingStatus(
            id = id,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: MeetingStatus,
        entityRequest: MeetingStatusDTOs.PutRequest
    ): MeetingStatus {
        return MeetingStatus(
            id = entity.id,
            name = entityRequest.name?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}
