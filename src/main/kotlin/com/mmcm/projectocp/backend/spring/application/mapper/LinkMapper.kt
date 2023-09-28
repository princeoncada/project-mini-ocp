package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.LinkDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Link
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyBranchRepository
import com.mmcm.projectocp.backend.spring.domain.repository.LinkTypeRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class LinkMapper(
    private val companyBranchRepository: CompanyBranchRepository,
    private val linkTypeRepository: LinkTypeRepository
): EntityMapper<Link, LinkDTOs.GetResult, LinkDTOs.PostRequest, LinkDTOs.PutRequest> {
    override fun toGetResult(
        entity: Link
    ): LinkDTOs.GetResult {
        return LinkDTOs.GetResult(
            id = entity.id,
            branch = entity.branch.name,
            linkType = entity.linkType.type,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: LinkDTOs.PostRequest
    ): Link {
        return Link(
            id = id,
            branch = companyBranchRepository.findByName(entityRequest.branch).get(),
            linkType = linkTypeRepository.findByType(entityRequest.linkType).get(),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Link,
        entityRequest: LinkDTOs.PutRequest
    ): Link {
        return Link(
            id = entity.id,
            branch = companyBranchRepository.findByName(entityRequest.branch!!).get(),
            linkType = linkTypeRepository.findByType(entityRequest.linkType!!).get(),
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}