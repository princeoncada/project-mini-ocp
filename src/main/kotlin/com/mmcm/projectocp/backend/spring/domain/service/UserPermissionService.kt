package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserPermissionDTOs
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
interface UserPermissionService {
    fun getEntities(
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult>

    fun getEntityByKey(
        user: String,
        permission: String,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult>

    fun createEntity(
        entityRequest: UserPermissionDTOs.PostRequest,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult>

    fun updateEntityByKey(
        user: String,
        permission: String,
        entityRequest: UserPermissionDTOs.PutRequest,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult>

    fun deleteEntityByKey(
        user: String,
        permission: String,
        pageable: Pageable
    ): Page<UserPermissionDTOs.GetResult>
}