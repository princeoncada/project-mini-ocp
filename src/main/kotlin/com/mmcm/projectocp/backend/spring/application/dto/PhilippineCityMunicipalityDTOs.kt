package com.mmcm.projectocp.backend.spring.application.dto

class PhilippineCityMunicipalityDTOs {
    data class GetResult(
        val id: String,
        val munCode: String,
        val provCode: String,
        val name: String,
    )

    data class PostRequest(
        val munCode: String,
        val provCode: String,
        val name: String,
    )

    data class PutRequest(
        val munCode: String?,
        val provCode: String?,
        val name: String?,
    )
}