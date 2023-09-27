package com.mmcm.projectocp.backend.spring.application.dto

class PhilippineProvinceDTOs {
    data class GetResult(
        val id: String,
        val provCode: String,
        val regCode: String,
        val name: String,
    )

    data class PostRequest(
        val provCode: String,
        val regCode: String,
        val name: String,
    )

    data class PutRequest(
        val provCode: String?,
        val regCode: String?,
        val name: String?,
    )
}