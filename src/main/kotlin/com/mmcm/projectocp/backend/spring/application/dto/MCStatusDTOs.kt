package com.mmcm.projectocp.backend.spring.application.dto

class MCStatusDTOs {
    data class GetResult(
        val id: String,
        val name: String,
    )

    data class PostRequest(
        val name: String,
    )

    data class PutRequest(
        val name: String?,
    )
}
