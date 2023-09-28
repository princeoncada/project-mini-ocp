package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MoaDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Moa
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyBranchRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDate

@Component
class MoaMapper(
    private val companyBranchRepository: CompanyBranchRepository
): EntityMapper<Moa, MoaDTOs.GetResult, MoaDTOs.PostRequest, MoaDTOs.PutRequest> {
    override fun toGetResult(
        entity: Moa
    ): MoaDTOs.GetResult {
        return MoaDTOs.GetResult(
            id = entity.id,
            branch = entity.branch.name,
            title = entity.title,
            startDate = entity.startDate.toString(),
            expiryDate = entity.expiryDate.toString(),
            description = entity.description,
            vpaaSubmission = entity.vpaaSubmission.toString(),
            isActive = entity.isActive.toString(),
            isHiring = entity.isHiring.toString(),
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MoaDTOs.PostRequest
    ): Moa {
        return Moa(
            id = id,
            branch = companyBranchRepository.findByName(entityRequest.branch).get(),
            title = entityRequest.title,
            startDate = LocalDate.parse(entityRequest.startDate),
            expiryDate = LocalDate.parse(entityRequest.expiryDate),
            description = entityRequest.description,
            vpaaSubmission = LocalDate.parse(entityRequest.vpaaSubmission),
            isActive = entityRequest.isActive.toBoolean(),
            isHiring = entityRequest.isHiring.toBoolean(),
            createdAt = Instant.now(),
            updatedAt = Instant.now(),

        )
    }

    override fun updateEntity(
        entity: Moa,
        entityRequest: MoaDTOs.PutRequest
    ): Moa {
        return Moa(
            id = entity.id,
            branch = companyBranchRepository.findByName(entityRequest.branch ?: entity.branch.name).get(),
            title = entityRequest.title ?: entity.title,
            startDate = LocalDate.parse(entityRequest.startDate ?: entity.startDate.toString()),
            expiryDate = LocalDate.parse(entityRequest.expiryDate ?: entity.expiryDate.toString()),
            description = entityRequest.description ?: entity.description,
            vpaaSubmission = LocalDate.parse(entityRequest.vpaaSubmission ?: entity.vpaaSubmission.toString()),
            isActive = entityRequest.isActive?.toBoolean() ?: entity.isActive,
            isHiring = entityRequest.isHiring?.toBoolean() ?: entity.isHiring,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}