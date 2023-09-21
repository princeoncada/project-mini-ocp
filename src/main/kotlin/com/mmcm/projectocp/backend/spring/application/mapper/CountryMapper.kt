package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CountryDto
import com.mmcm.projectocp.backend.spring.domain.model.Country
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class CountryMapper {

    abstract fun toEntity(countryDto: CountryDto): Country

    abstract fun toDto(country: Country): CountryDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(
        countryDto: CountryDto,
        @MappingTarget country: Country
    ): Country
}