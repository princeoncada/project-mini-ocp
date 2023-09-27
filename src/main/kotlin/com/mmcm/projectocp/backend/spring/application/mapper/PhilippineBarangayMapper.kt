package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineBarangayDTOs
import com.mmcm.projectocp.backend.spring.domain.model.PhilippineBarangay
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class PhilippineBarangayMapper: EntityMapper<PhilippineBarangay, PhilippineBarangayDTOs.GetResult, PhilippineBarangayDTOs.PostRequest, PhilippineBarangayDTOs.PutRequest> {
    override fun toGetResult(
        entity: PhilippineBarangay
    ): PhilippineBarangayDTOs.GetResult {
        return PhilippineBarangayDTOs.GetResult(
            id = entity.id,
            munCode = entity.municipalityCode,
            name = entity.name,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: PhilippineBarangayDTOs.PostRequest
    ): PhilippineBarangay {
        return PhilippineBarangay(
            id = id,
            municipalityCode = entityRequest.munCode,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: PhilippineBarangay,
        entityRequest: PhilippineBarangayDTOs.PutRequest
    ): PhilippineBarangay {
        return PhilippineBarangay(
            id = entity.id,
            municipalityCode = entityRequest.munCode ?: entity.municipalityCode,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}