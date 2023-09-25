package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.UserPermission
import com.mmcm.projectocp.backend.spring.domain.model.UserPermissionKey
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserPermissionRepository: JpaRepository<UserPermission, UserPermissionKey> {
    override fun findAll(pageable: Pageable): Page<UserPermission>
    fun findById(id: UserPermissionKey, pageable: Pageable): Optional<Page<UserPermission>>
}
