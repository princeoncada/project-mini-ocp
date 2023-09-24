package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CountryDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Country
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class CountryMapper : EntityMapper<Country, CountryDTOs.GetResult, CountryDTOs.PostRequest, CountryDTOs.PutRequest>{
    override fun toGetResult(entity: Country): CountryDTOs.GetResult {
        return CountryDTOs.GetResult(
            id = entity.id,
            isoCode = entity.isoCode,
            name = entity.name
        )
    }

    override fun createEntity(id: String, entityRequest: CountryDTOs.PostRequest): Country {
        return Country(
            id = id,
            isoCode = entityRequest.isoCode,
            name = entityRequest.name,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(entity: Country, entityRequest: CountryDTOs.PutRequest): Country {
        return Country(
            id = entity.id,
            isoCode = entityRequest.isoCode ?: entity.isoCode,
            name = entityRequest.name ?: entity.name,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}