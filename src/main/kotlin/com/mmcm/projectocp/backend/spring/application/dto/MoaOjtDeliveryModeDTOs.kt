package com.mmcm.projectocp.backend.spring.application.dto

class MoaOjtDeliveryModeDTOs {
    data class GetResult(
        val id: String,
        val moa: String?,
        val ojtDeliveryMode: String,
    )

    data class PostRequest(
        val moa: String,
        val ojtDeliveryMode: String,
    )

    data class PutRequest(
        val moa: String?,
        val ojtDeliveryMode: String?,
    )
}