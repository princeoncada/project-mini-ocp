package com.mmcm.projectocp.backend.spring.impl.domain.service


import com.mmcm.projectocp.backend.spring.application.rest.UserController
import com.mmcm.projectocp.backend.spring.domain.mapper.UserMapper
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserService {
    override fun register(userCreateRequest: UserController.UserCreateRequest): UserController.UserCreateRequest {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userCreateRequest)))
    }

}