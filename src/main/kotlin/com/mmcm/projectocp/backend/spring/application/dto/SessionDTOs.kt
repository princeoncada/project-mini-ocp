package com.mmcm.projectocp.backend.spring.application.dto

class SessionDTOs {
    data class GetResult(
        val id: String,
        val user: String,
        val expiresOn: String
    )

    data class PostRequest(
        val user: String,
        val expiresOn: String
    )

    data class PutRequest(
        val user: String?,
        val expiresOn: String?
    )
}