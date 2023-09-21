package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.Embeddable
import jakarta.persistence.Id
import java.io.Serializable

@Embeddable
data class UserPermissionKey(
    val user: String,
    val permission: String
) : Serializable{

}