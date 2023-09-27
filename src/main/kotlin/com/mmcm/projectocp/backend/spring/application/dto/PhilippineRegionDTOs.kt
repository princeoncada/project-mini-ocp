package com.mmcm.projectocp.backend.spring.application.dto

class PhilippineRegionDTOs {
    data class GetResult(
        val id: String,
        val regCode: String,
        val name: String,
    )

    data class PostRequest(
        val regCode: String,
        val name: String,
    )

    data class PutRequest(
        val regCode: String?,
        val name: String?,
    )
}