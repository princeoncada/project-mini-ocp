package com.mmcm.projectocp.backend.spring.application.dto

class CountryDTOs {
    data class GetResult(
        val id: String,
        val name: String,
        val isoCode: String
    )

    data class PostRequest(
        val isoCode: String,
        val name: String
    )

    data class PutRequest(
        val isoCode: String?,
        val name: String?
    )
}