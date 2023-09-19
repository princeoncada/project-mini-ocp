package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserRegisterRequest
import com.mmcm.projectocp.backend.spring.domain.model.UserEntity
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class UserRegisterMapper {

    abstract fun toEntity(userRegisterRequest: UserRegisterRequest): UserEntity

    abstract fun toDto(userEntity: UserEntity): UserRegisterRequest

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(userRegisterRequest: UserRegisterRequest, @MappingTarget userEntity: UserEntity): UserEntity
}