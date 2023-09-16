package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.domain.dto.UserDTO
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun register(req: UserDTO): UserDTO
    fun getAuth(req: UserDTO): UserDTO
    fun getPermsissions(req: UserDTO): UserDTO
    fun getAllPermsissions(req: UserDTO): UserDTO
    fun getRole(req: UserDTO): UserDTO
    fun signIn(req: UserDTO): UserDTO
    fun signOut(req: UserDTO): UserDTO


}