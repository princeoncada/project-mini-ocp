package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.TermDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Term
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class TermMapper: EntityMapper<Term, TermDTOs.GetResult, TermDTOs.PostRequest, TermDTOs.PutRequest> {
    override fun toGetResult(
        entity: Term
    ): TermDTOs.GetResult {
        return TermDTOs.GetResult(
            id = entity.id,
            code = entity.code
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: TermDTOs.PostRequest
    ): Term {
        return Term(
            id = id,
            code = entityRequest.code,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Term,
        entityRequest: TermDTOs.PutRequest
    ): Term {
        return Term(
            id = entity.id,
            code = entityRequest.code,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}