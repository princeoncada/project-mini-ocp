package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserPermissionDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.UserPermissionMapper
import com.mmcm.projectocp.backend.spring.domain.model.UserPermissionKey
import com.mmcm.projectocp.backend.spring.domain.repository.PermissionRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserPermissionRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserPermissionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class UserPermissionServiceImpl(
    private val userPermissionRepository: UserPermissionRepository,
    private val userRepository: UserRepository,
    private val permissionRepository: PermissionRepository,
    private val userPermissionMapper: UserPermissionMapper
): UserPermissionService {
    override fun getEntities(
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult> {
        return userPermissionRepository.findAll(pageable).map { userPermissionMapper.toGetResult(it) }
    }

    override fun getEntityByKey(
        user: String,
        permission: String,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult> {
        return userPermissionRepository.findById(
            UserPermissionKey(
                userId = userRepository.findByEmail(user).getOrNull()?.id
                    ?: userRepository.findById(user).get().id,
                permissionId = permissionRepository.findByName(permission).getOrNull()?.id
                    ?: permissionRepository.findById(permission).get().id
            ), pageable
        ).get().map { userPermissionMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: UserPermissionDTOs.PostRequest,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult> {
        val savedUserPermission = userPermissionRepository.save(userPermissionMapper.createEntity(entityRequest))
        return userPermissionRepository.findById(savedUserPermission.id, pageable).get().map { userPermissionMapper.toGetResult(it) }
    }

    override fun updateEntityByKey(
        user: String,
        permission: String,
        entityRequest: UserPermissionDTOs.PutRequest,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult> {
        val currentUserPermission = userPermissionRepository.findById(
            UserPermissionKey(
                userId = userRepository.findByEmail(user).getOrNull()?.id
                    ?: userRepository.findById(user).get().id,
                permissionId = permissionRepository.findByName(permission).getOrNull()?.id
                    ?: permissionRepository.findById(permission).get().id
            )
        ).get()

        val savedUserPermission = userPermissionRepository.save(userPermissionMapper.updateEntity(currentUserPermission, entityRequest))
        userPermissionRepository.delete(currentUserPermission)

        return userPermissionRepository.findById(
            UserPermissionKey(
                userId = savedUserPermission.id.userId,
                permissionId = savedUserPermission.id.permissionId
            ), pageable
        ).get().map { userPermissionMapper.toGetResult(it) }
    }

    override fun deleteEntityByKey(
        user: String,
        permission: String,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult> {
        val userPermission = userPermissionRepository.findById(
            UserPermissionKey(
                userId = userRepository.findByEmail(user).getOrNull()?.id
                    ?: userRepository.findById(user).get().id,
                permissionId = permissionRepository.findByName(permission).getOrNull()?.id
                    ?: permissionRepository.findById(permission).get().id
            )
        ).get()
        userPermissionRepository.delete(userPermission)
        return userPermissionRepository.findAll(pageable).map { userPermissionMapper.toGetResult(it) }
    }
}