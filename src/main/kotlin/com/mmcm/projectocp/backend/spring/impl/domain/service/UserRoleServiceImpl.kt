package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.UserRoleMapper
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserRoleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserRoleServiceImpl(
        private val userRoleRepository: UserRoleRepository,
        private val userRepository: UserRepository,
        private val userRoleMapper: UserRoleMapper
): UserRoleService {
    override fun getEntities(
        pageable: Pageable
    ): Page<UserRoleDTOs.GetResult> {
        return userRoleRepository.findAll(pageable).map { userRoleMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<UserRoleDTOs.GetResult> {
        return userRoleRepository.findById(id, pageable).map { userRoleMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: UserRoleDTOs.PostRequest,
        pageable: Pageable
    ): Page<UserRoleDTOs.GetResult> {
        val userRoleId = UUID.randomUUID().toString()
        val savedUserRole = userRoleRepository.save(userRoleMapper.createEntity(userRoleId, entityRequest))
        return userRoleRepository.findById(savedUserRole.id, pageable).map { userRoleMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: UserRoleDTOs.PutRequest,
        pageable: Pageable
    ): Page<UserRoleDTOs.GetResult> {
        val currentUserRole = userRoleRepository.findById(id).get()
        val savedUserRole = userRoleRepository.save(userRoleMapper.updateEntity(currentUserRole, entityRequest))
        return userRoleRepository.findById(savedUserRole.id, pageable).map { userRoleMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<UserRoleDTOs.GetResult> {
        val userRole = userRoleRepository.findById(id).get()
        userRoleRepository.delete(userRole)
        return userRoleRepository.findAll(pageable).map { userRoleMapper.toGetResult(it) }
    }

    override fun isAdmin(
        userId: String
    ): Boolean {
        return userRoleRepository.findByUserId(userId).role.name == "admin"
    }

    override fun findByEmail(email: String): Optional<UserRole> {
        val userId = userRepository.findByEmail(email).get().id
        return userRoleRepository.findById(userId)
    }
}