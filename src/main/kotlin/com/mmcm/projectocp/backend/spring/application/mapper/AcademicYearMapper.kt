package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYearDTO
import com.mmcm.projectocp.backend.spring.domain.model.AcademicYear
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class AcademicYearMapper {

    abstract fun toEntity(academicYearDto: AcademicYearDTO): AcademicYear

    abstract fun toDto(academicYear: AcademicYear): AcademicYearDTO

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(
        academicYearDto: AcademicYearDTO,
        @MappingTarget academicYear: AcademicYear
    ): AcademicYear
}