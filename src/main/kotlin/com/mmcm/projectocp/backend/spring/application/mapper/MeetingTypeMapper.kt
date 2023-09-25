package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MeetingTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.MeetingType
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class MeetingTypeMapper : EntityMapper<MeetingType, MeetingTypeDTOs.GetResult, MeetingTypeDTOs.PostRequest, MeetingTypeDTOs.PutRequest> {
    override fun toGetResult(
        entity: MeetingType
    ): MeetingTypeDTOs.GetResult {
        return MeetingTypeDTOs.GetResult(
            id = entity.id,
            name = entity.name,
            meetingMode = entity.meetingMode,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MeetingTypeDTOs.PostRequest
    ): MeetingType {
        return MeetingType(
            id = id,
            name = entityRequest.name,
            meetingMode = entityRequest.meetingMode,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: MeetingType,
        entityRequest: MeetingTypeDTOs.PutRequest
    ): MeetingType {
        return MeetingType(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            meetingMode = entityRequest.meetingMode ?: entity.meetingMode,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}
