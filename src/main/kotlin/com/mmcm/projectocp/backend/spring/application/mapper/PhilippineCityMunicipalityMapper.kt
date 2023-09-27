package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineCityMunicipalityDTOs
import com.mmcm.projectocp.backend.spring.domain.model.PhilippineCityMunicipality
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class PhilippineCityMunicipalityMapper :
    EntityMapper<PhilippineCityMunicipality, PhilippineCityMunicipalityDTOs.GetResult, PhilippineCityMunicipalityDTOs.PostRequest, PhilippineCityMunicipalityDTOs.PutRequest> {
    override fun toGetResult(
        entity: PhilippineCityMunicipality
    ): PhilippineCityMunicipalityDTOs.GetResult {
        return PhilippineCityMunicipalityDTOs.GetResult(
            id = entity.id,
            munCode = entity.municipalityCode,
            provCode = entity.provinceCode,
            name = entity.name
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: PhilippineCityMunicipalityDTOs.PostRequest
    ): PhilippineCityMunicipality {
        return PhilippineCityMunicipality(
            id = id,
            municipalityCode = entityRequest.munCode,
            provinceCode = entityRequest.provCode,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: PhilippineCityMunicipality,
        entityRequest: PhilippineCityMunicipalityDTOs.PutRequest
    ): PhilippineCityMunicipality {
        return PhilippineCityMunicipality(
            id = entity.id,
            municipalityCode = entityRequest.munCode ?: entity.municipalityCode,
            provinceCode = entityRequest.provCode ?: entity.provinceCode,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}