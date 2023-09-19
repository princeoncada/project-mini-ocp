package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserAuthResponse
import com.mmcm.projectocp.backend.spring.application.dto.UserLoginRequest
import com.mmcm.projectocp.backend.spring.application.dto.UserRegisterRequest
import com.mmcm.projectocp.backend.spring.application.mapper.UserRegisterMapper
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import com.mmcm.projectocp.backend.spring.domain.repository.RoleRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import com.mmcm.projectocp.backend.spring.security.config.JwtService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userRegisterMapper: UserRegisterMapper,
    private val roleRepository: RoleRepository,
    private val userRoleRepository: UserRoleRepository,
    private val authenticationManager: AuthenticationManager,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,

    ) : UserService {
    override fun register(userRegisterRequest: UserRegisterRequest): UserAuthResponse {
        val existUser = userRepository.existsByEmailAndStudentId(
                        userRegisterRequest.email,
                        userRegisterRequest.studentId)
        when {
            existUser -> throw Exception("User already exists!")
            else -> {
                val studentRole = roleRepository.findByName("student")
                val user = userRegisterMapper.toEntity(userRegisterRequest)
                val encodedPassword = passwordEncoder.encode(userRegisterRequest.studentId)
                user.studentId = encodedPassword
                val savedUser = userRepository.save(user)

                val userRole = UserRole().apply {
                    this.userEntity = savedUser
                    this.role = studentRole
                }


                val jwtToken = jwtService.generateToken(savedUser)
                userRoleRepository.save(userRole)
                userRegisterMapper.toDto(savedUser)
                return UserAuthResponse(jwtToken)
            }
        }

    }

    override fun signIn(userLoginRequest: UserLoginRequest): UserAuthResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                userLoginRequest.email,
                userLoginRequest.studentId)
        )
        val user = userRepository.findByEmail(userLoginRequest.email)
            .orElseThrow { Exception("User not found") }
        val token = jwtService.generateToken(user)
        return UserAuthResponse(token)

    }


}