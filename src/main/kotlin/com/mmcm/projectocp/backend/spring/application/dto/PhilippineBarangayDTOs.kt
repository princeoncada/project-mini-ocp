package com.mmcm.projectocp.backend.spring.application.dto

class PhilippineBarangayDTOs {
    data class GetResult(
        val id: String,
        val munCode: String,
        val name: String,
    )

    data class PostRequest(
        val munCode: String,
        val name: String,
    )

    data class PutRequest(
        val munCode: String?,
        val name: String?,
    )
}