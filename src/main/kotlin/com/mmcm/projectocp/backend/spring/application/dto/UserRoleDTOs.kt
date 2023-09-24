package com.mmcm.projectocp.backend.spring.application.dto

class UserRoleDTOs {
    data class GetResult(
        val id: String,
        val user: String,
        val role: String
    )

    data class PostRequest (
        val user: String,
        val role: String
    )

    data class PutRequest(
        val user: String?,
        val role: String?
    )
}