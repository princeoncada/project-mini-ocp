package com.mmcm.projectocp.backend.spring.application.mapper


import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTO
import com.mmcm.projectocp.backend.spring.domain.model.Department
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class DepartmentMapper {

    abstract fun toEntity(departmentDTO: DepartmentDTO): Department

    abstract fun toDto(department: Department): DepartmentDTO


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(
        departmentDTO: DepartmentDTO,
        @MappingTarget department: Department): Department
}