package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserAuthResponse
import com.mmcm.projectocp.backend.spring.application.dto.UserLoginRequest
import com.mmcm.projectocp.backend.spring.application.dto.UserRegisterRequest
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController (
    private val userService: UserService
) {

    @PostMapping("/register")
    fun register(@RequestBody userRegisterRequest: UserRegisterRequest): ResponseEntity<UserAuthResponse> {
        return ResponseEntity.ok(userService.register(userRegisterRequest))
    }

    @PostMapping("/login")
    fun signIn(@RequestBody userLoginRequest: UserLoginRequest): ResponseEntity<UserAuthResponse> {
        return ResponseEntity.ok(userService.signIn(userLoginRequest))
    }
}