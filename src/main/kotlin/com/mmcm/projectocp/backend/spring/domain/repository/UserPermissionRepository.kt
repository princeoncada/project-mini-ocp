package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.UserPermission
import com.mmcm.projectocp.backend.spring.domain.model.UserPermissionKey
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserPermissionRepository : JpaRepository<UserPermission, UserPermissionKey> {
    // You can add custom query methods here if needed
}
