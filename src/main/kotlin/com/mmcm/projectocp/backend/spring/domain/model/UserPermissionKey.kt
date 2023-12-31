package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class UserPermissionKey(
    val userId: String,
    val permissionId: String
) : Serializable