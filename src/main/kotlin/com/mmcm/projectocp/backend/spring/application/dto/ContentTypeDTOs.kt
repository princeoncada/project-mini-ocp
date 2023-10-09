package com.mmcm.projectocp.backend.spring.application.dto

class ContentTypeDTOs {
    data class GetResult(
        val id: String,
        val type: String
    )

    data class PostRequest(
        val type: String
    )

    data class PutRequest(
        val type: String
    )
}