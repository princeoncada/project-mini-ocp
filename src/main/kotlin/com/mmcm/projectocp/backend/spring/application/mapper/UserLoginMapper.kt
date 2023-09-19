package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserLoginRequest
import com.mmcm.projectocp.backend.spring.domain.model.UserEntity
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class UserLoginMapper {

    abstract fun toEntity(userLoginRequest: UserLoginRequest): UserEntity

    abstract fun toDto(userEntity: UserEntity): UserLoginRequest

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(userLoginRequest: UserLoginRequest, @MappingTarget userEntity: UserEntity): UserEntity
}