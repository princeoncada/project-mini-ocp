package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CountryDTO
import com.mmcm.projectocp.backend.spring.domain.model.Country
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class CountryMapper {

    abstract fun toEntity(countryDTO: CountryDTO): Country

    abstract fun toDto(country: Country): CountryDTO

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(countryDTO: CountryDTO, @MappingTarget country: Country): Country
}