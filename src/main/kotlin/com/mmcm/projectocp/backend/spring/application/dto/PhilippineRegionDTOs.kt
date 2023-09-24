package com.mmcm.projectocp.backend.spring.application.dto

class PhilippineRegionDTOs {
    data class GetResult(
        val id: String,
        val regionCode: String,
        val name: String,
    )

    data class PostRequest(
        val regionCode: String,
        val name: String,
    )

    data class PutRequest(
        val regionCode: String?,
        val name: String?,
    )
}
