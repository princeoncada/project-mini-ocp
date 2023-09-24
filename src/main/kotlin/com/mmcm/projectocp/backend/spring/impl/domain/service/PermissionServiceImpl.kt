package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PermissionDTOs.*
import com.mmcm.projectocp.backend.spring.application.mapper.PermissionMapper
import com.mmcm.projectocp.backend.spring.domain.model.Permission
import com.mmcm.projectocp.backend.spring.domain.repository.PermissionRepository
import com.mmcm.projectocp.backend.spring.domain.service.PermissionService
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID
@Service
class PermissionServiceImpl(
    private val permissionRepository: PermissionRepository,
    private val permissionMapper: PermissionMapper
): PermissionService {
    override fun getEntities(
        pageable: Pageable
    ): Page<GetResult> {
        return permissionRepository.findAll(pageable).map { permissionMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String, pageable: Pageable
    ): Page<GetResult> {
        val permission = permissionRepository.findById(id, pageable) ?: throw NotFoundException()
        return permission.map { permissionMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: PostRequest,
        pageable: Pageable
    ): Page<GetResult> {
        val permissionId = UUID.randomUUID().toString()
        val savedPermission = permissionRepository.save(permissionMapper.createEntity(permissionId, entityRequest))
        return permissionRepository.findById(savedPermission.id, pageable).map { permissionMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: PutRequest,
        pageable: Pageable
    ): Page<GetResult> {
        val currentPermission = permissionRepository.findById(id).get()
        permissionRepository.save(permissionMapper.updateEntity(currentPermission, entityRequest))
        return permissionRepository.findById(id, pageable).map { permissionMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<GetResult> {
        val permission = permissionRepository.findById(id).get()
        permissionRepository.delete(permission)
        return permissionRepository.findAll(pageable).map { permissionMapper.toGetResult(it) }
    }
}