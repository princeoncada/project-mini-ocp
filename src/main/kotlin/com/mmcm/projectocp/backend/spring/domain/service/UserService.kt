package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.rest.UserController
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun register(userCreateRequest: UserController.UserCreateRequest): UserController.UserCreateRequest


}