package com.mmcm.projectocp.backend.spring.application.dto

class UserPermissionDTOs {
    data class GetResult(
        val userId: String,
        val permissionId: String,
        val user: String,
        val permission: String
    )

    data class PostRequest(
        val user: String,
        val permission: String
    )

    data class PutRequest(
        val user: String?,
        val permission: String?
    )
}