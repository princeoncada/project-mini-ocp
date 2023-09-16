package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.domain.dto.UserDTO
import com.mmcm.projectocp.backend.spring.domain.mapper.UserMapper
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
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

    override fun getPermsissions(req: UserDTO): UserDTO {
        TODO("Not yet implemented")
    }

    override fun getAllPermsissions(req: UserDTO): UserDTO {
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




}