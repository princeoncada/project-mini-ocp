package com.mmcm.projectocp.backend.spring.application.dto

class FileDTOs {
    data class GetResult(
        val id: String,
        val fileType: String,
        val parentId: String,
        val name: String,
        val mimetype: String,
        val path: String,
        val key: String,
        val uploadedBy: String,
        val order: Int?,
    )

    data class PostRequest(
        val fileType: String,
        val parentId: String,
        val name: String,
        val mimetype: String,
        val path: String,
        val key: String,
        val uploadedBy: String,
        val order: Int?,
    )

    data class PutRequest(
        val fileType: String?,
        val parentId: String?,
        val name: String?,
        val mimetype: String?,
        val path: String?,
        val key: String?,
        val uploadedBy: String?,
        val order: Int?,
    )
}