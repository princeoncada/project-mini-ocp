package com.mmcm.projectocp.backend.spring.application.dto

class OJTDeliveryModeDTOs {
    data class GetResult(
        val id: String,
        val mode: String,
    )

    data class PostRequest(
        val mode: String,
    )

    data class PutRequest(
        val mode: String?,
    )
}