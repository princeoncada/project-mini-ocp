package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserDTO
import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTO
import com.mmcm.projectocp.backend.spring.application.mapper.UserMapper
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userRoleRepository: UserRoleRepository,
    private val userMapper: UserMapper
) : UserService {
    override fun register(req: UserDTO): UserDTO {
        val userEntity = userMapper.toUserEntity(req)
        val userEntityCreated = userRepository.save(userEntity)
        return userMapper.toUserDTO(userEntityCreated)
    }

    override fun getAuth(req: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun getPermissions(req: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun getAllPermissions(req: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun getRole(req: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }


    override fun signIn(req: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun signOut(req: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }




    fun userRoleMapping(userRole: UserRole): UserRoleDTO {
        return UserRoleDTO(
            id = userRole.id,
            user = userRole.user.email,
            role = userRole.role.name
        )
    }
    override fun findByUsername(email: String): UserRole {
        val userId = userRepository.findByEmail(email).id ?: throw UsernameNotFoundException("User not found with username: $email")
        return userRoleRepository.findByUserId(userId)
    }


}