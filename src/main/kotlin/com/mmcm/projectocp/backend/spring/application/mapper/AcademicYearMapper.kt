package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYeartDto
import com.mmcm.projectocp.backend.spring.domain.model.AcademicYear
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class AcademicYearMapper {

    abstract fun toEntity(academicYearDto: AcademicYeartDto): AcademicYear

    abstract fun toDto(academicYear: AcademicYear): AcademicYeartDto

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(
        academicYeartDto: AcademicYeartDto,
        @MappingTarget academicYear: AcademicYear
    ): AcademicYear
}