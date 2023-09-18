package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserDTO
import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTO
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun register(req: UserDTO): UserDTO
    fun getAuth(req: UserDTO): UserDTO
    fun getPermissions(req: UserDTO): UserDTO
    fun getAllPermissions(req: UserDTO): UserDTO
    fun getRole(req: UserDTO): UserDTO
    fun signIn(req: UserDTO): UserDTO
    fun signOut(req: UserDTO): UserDTO
    fun findByUsername(email: String): UserRole
}