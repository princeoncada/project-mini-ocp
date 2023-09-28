package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.McStatusUpdateDTOs
import com.mmcm.projectocp.backend.spring.domain.model.McStatusUpdate
import com.mmcm.projectocp.backend.spring.domain.repository.McStatusRepository
import com.mmcm.projectocp.backend.spring.domain.repository.MoaRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDate
import kotlin.jvm.optionals.getOrNull

@Component
class McStatusUpdateMapper(
    private val mcStatusRepository: McStatusRepository,
    private val moaRepository: MoaRepository
): EntityMapper<McStatusUpdate, McStatusUpdateDTOs.GetResult, McStatusUpdateDTOs.PostRequest, McStatusUpdateDTOs.PutRequest> {
    override fun toGetResult(
        entity: McStatusUpdate
    ): McStatusUpdateDTOs.GetResult {
        return McStatusUpdateDTOs.GetResult(
            id = entity.id,
            mcStatus = entity.mcStatus.name,
            moa = entity.moa.title,
            notes = entity.notes,
            mcApprovedDate = entity.mcApprovedDate.toString(),
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: McStatusUpdateDTOs.PostRequest
    ): McStatusUpdate {
        return McStatusUpdate(
            id = id,
            mcStatus = mcStatusRepository.findByName(entityRequest.mcStatus).get(),
            moa = moaRepository.findByTitle(entityRequest.moa).get(),
            notes = entityRequest.notes,
            mcApprovedDate = LocalDate.parse(entityRequest.mcApprovedDate),
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: McStatusUpdate,
        entityRequest: McStatusUpdateDTOs.PutRequest
    ): McStatusUpdate {
        return McStatusUpdate(
            id = entity.id,
            mcStatus = mcStatusRepository.findByName(entityRequest.mcStatus).getOrNull() ?: entity.mcStatus,
            moa = moaRepository.findByTitle(entityRequest.moa).getOrNull() ?: entity.moa,
            notes = entityRequest.notes ?: entity.notes,
            mcApprovedDate = entityRequest.mcApprovedDate?.let { LocalDate.parse(it) } ?: entity.mcApprovedDate,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}