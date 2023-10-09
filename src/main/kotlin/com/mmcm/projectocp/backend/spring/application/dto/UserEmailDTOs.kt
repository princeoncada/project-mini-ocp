package com.mmcm.projectocp.backend.spring.application.dto

class UserEmailDTOs {
    data class GetResult(
        val id: String,
        val userId: String,
        val email: String
    )

    data class PostRequest(
        val userId: String,
        val email: String
    )

    data class PutRequest(
        val userId: String?,
        val email: String?
    )
}