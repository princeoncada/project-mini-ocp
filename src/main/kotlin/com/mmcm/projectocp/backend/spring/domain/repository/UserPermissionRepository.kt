package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.UserPermission
import org.springframework.data.jpa.repository.JpaRepository

interface UserPermissionRepository : JpaRepository<UserPermission, String> {
    // You can add custom query methods here if needed
}
