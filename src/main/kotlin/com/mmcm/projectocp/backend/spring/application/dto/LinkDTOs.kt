package com.mmcm.projectocp.backend.spring.application.dto

class LinkDTOs {
    data class GetResult(
        val id: String,
        val branch: String,
        val linkType: String,
    )

    data class PostRequest(
        val branch: String,
        val linkType: String,
    )

    data class PutRequest(
        val branch: String?,
        val linkType: String?,
    )
}