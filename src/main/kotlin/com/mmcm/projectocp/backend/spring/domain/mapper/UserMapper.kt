package com.mmcm.projectocp.backend.spring.domain.mapper

import com.mmcm.projectocp.backend.spring.application.rest.UserController
import com.mmcm.projectocp.backend.spring.domain.model.User
import org.mapstruct.*

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
abstract class UserMapper {

    abstract fun toEntity(userCreateRequest: UserController.UserCreateRequest): User

    abstract fun toDto(user: User): UserController.UserCreateRequest

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    abstract fun partialUpdate(userCreateRequest: UserController.UserCreateRequest, @MappingTarget user: User): User
}