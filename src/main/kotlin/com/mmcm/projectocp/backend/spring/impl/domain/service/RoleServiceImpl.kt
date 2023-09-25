package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RoleDTOs.*
import com.mmcm.projectocp.backend.spring.application.mapper.RoleMapper
import com.mmcm.projectocp.backend.spring.domain.repository.RoleRepository
import com.mmcm.projectocp.backend.spring.domain.service.RoleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class RoleServiceImpl(
    private val roleRepository: RoleRepository,
    private val roleMapper: RoleMapper
): RoleService {
    override fun getEntities(
        pageable: Pageable
    ): Page<GetResult> {
        return roleRepository.findAll(pageable).map { roleMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<GetResult> {
        val role = roleRepository.findById(id, pageable)
        return role.map { roleMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: PostRequest,
        pageable: Pageable
    ): Page<GetResult> {
        val roleId = UUID.randomUUID().toString()
        val savedRole = roleRepository.save(roleMapper.createEntity(roleId, entityRequest))
        return roleRepository.findById(savedRole.id, pageable).map { roleMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: PutRequest,
        pageable: Pageable
    ): Page<GetResult> {
        val currentRole = roleRepository.findById(id).get()
        val savedRole = roleRepository.save(roleMapper.updateEntity(currentRole, entityRequest))
        return roleRepository.findById(savedRole.id, pageable).map { roleMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<GetResult> {
        val role = roleRepository.findById(id).get()
        roleRepository.delete(role)
        return roleRepository.findAll(pageable).map { roleMapper.toGetResult(it) }
    }
}
