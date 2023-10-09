package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MoaPartnershipTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.model.MoaPartnershipType
import com.mmcm.projectocp.backend.spring.domain.repository.MoaRepository
import com.mmcm.projectocp.backend.spring.domain.repository.PartnershipTypeRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class MoaPartnershipTypeMapper(
    private val moaRepository: MoaRepository,
    private val partnershipTypeRepository: PartnershipTypeRepository
): EntityMapper<MoaPartnershipType, MoaPartnershipTypeDTOs.GetResult, MoaPartnershipTypeDTOs.PostRequest, MoaPartnershipTypeDTOs.PutRequest> {
    override fun toGetResult(
        entity: MoaPartnershipType
    ): MoaPartnershipTypeDTOs.GetResult {
        return MoaPartnershipTypeDTOs.GetResult(
            id = entity.id,
            moa = entity.moa.title,
            partnershipType = entity.partnershipType.type
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MoaPartnershipTypeDTOs.PostRequest
    ): MoaPartnershipType {
        return MoaPartnershipType(
            id = id,
            moa = moaRepository.findByTitle(entityRequest.moa).get(),
            partnershipType = partnershipTypeRepository.findByType(entityRequest.partnershipType).get(),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: MoaPartnershipType,
        entityRequest: MoaPartnershipTypeDTOs.PutRequest
    ): MoaPartnershipType {
        return MoaPartnershipType(
            id = entity.id,
            moa = moaRepository.findByTitle(entityRequest.moa).getOrNull() ?: entity.moa,
            partnershipType = partnershipTypeRepository.findByType(entityRequest.partnershipType).getOrNull() ?: entity.partnershipType,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}