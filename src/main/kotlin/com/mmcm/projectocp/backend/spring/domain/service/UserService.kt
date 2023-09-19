package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserAuthResponse
import com.mmcm.projectocp.backend.spring.application.dto.UserLoginRequest
import com.mmcm.projectocp.backend.spring.application.dto.UserRegisterRequest
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun register(userRegisterRequest: UserRegisterRequest): UserAuthResponse

    fun signIn(userLoginRequest: UserLoginRequest): UserAuthResponse



}