package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MoaOjtDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.MoaOjtDeliveryMode
import com.mmcm.projectocp.backend.spring.domain.repository.MoaRepository
import com.mmcm.projectocp.backend.spring.domain.repository.OjtDeliveryModeRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class MoaOjtDeliveryModeMapper(
    private val moaRepository: MoaRepository,
    private val ojtDeliveryModeRepository: OjtDeliveryModeRepository

): EntityMapper<MoaOjtDeliveryMode, MoaOjtDeliveryModeDTOs.GetResult, MoaOjtDeliveryModeDTOs.PostRequest, MoaOjtDeliveryModeDTOs.PutRequest> {
    override fun toGetResult(
        entity: MoaOjtDeliveryMode
    ): MoaOjtDeliveryModeDTOs.GetResult {
        return MoaOjtDeliveryModeDTOs.GetResult(
            id = entity.id,
            moa = entity.moa.title,
            ojtDeliveryMode = entity.ojtDeliveryMode.mode,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MoaOjtDeliveryModeDTOs.PostRequest
    ): MoaOjtDeliveryMode {
        return MoaOjtDeliveryMode(
            id = id,
            moa = moaRepository.findByTitle(entityRequest.moa).get(),
            ojtDeliveryMode = ojtDeliveryModeRepository.findByMode(entityRequest.ojtDeliveryMode).get(),
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: MoaOjtDeliveryMode,
        entityRequest: MoaOjtDeliveryModeDTOs.PutRequest
    ): MoaOjtDeliveryMode {
        return MoaOjtDeliveryMode(
            id = entity.id,
            moa = moaRepository.findByTitle(entityRequest.moa).getOrNull() ?: entity.moa,
            ojtDeliveryMode = ojtDeliveryModeRepository.findByMode(entityRequest.ojtDeliveryMode).getOrNull() ?: entity.ojtDeliveryMode,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}