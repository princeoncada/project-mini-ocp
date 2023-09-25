package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.UserMapper
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserService {
    override fun getEntities(
        pageable: Pageable
    ): Page<UserDTOs.GetResult> {
        return userRepository.findAll(pageable).map { userMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable,
    ): Page<UserDTOs.GetResult> {
        val user = userRepository.findById(id, pageable)
        return user.map { userMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: UserDTOs.PostRequest,
        pageable: Pageable,
    ): Page<UserDTOs.GetResult> {
        val userId = UUID.randomUUID().toString()
        val savedUser = userRepository.save(userMapper.createEntity(userId, entityRequest))
        return userRepository.findById(savedUser.id, pageable).map { userMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: UserDTOs.PutRequest,
        pageable: Pageable,
    ): Page<UserDTOs.GetResult> {
        val currentUser = userRepository.findById(id).get()
        val savedUser = userRepository.save(userMapper.updateEntity(currentUser, entityRequest))
        return userRepository.findById(savedUser.id, pageable).map { userMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable,
    ): Page<UserDTOs.GetResult> {
        val user = userRepository.findById(id).get()
        userRepository.delete(user)
        return userRepository.findAll(pageable).map { userMapper.toGetResult(it) }
    }
}