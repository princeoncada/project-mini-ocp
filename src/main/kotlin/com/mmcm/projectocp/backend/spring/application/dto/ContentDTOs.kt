package com.mmcm.projectocp.backend.spring.application.dto

class ContentDTOs {
    data class GetResult(
        val id: String,
        val contentType: String,
        val author: String,
        val title: String?,
        val content: String?,
        val isActive: Boolean?,
    )

    data class PostRequest(
        val contentType: String,
        val author: String,
        val title: String?,
        val content: String?,
        val isActive: Boolean?,
    )

    data class PutRequest(
        val contentType: String?,
        val author: String?,
        val title: String?,
        val content: String?,
        val isActive: Boolean?,
    )
}