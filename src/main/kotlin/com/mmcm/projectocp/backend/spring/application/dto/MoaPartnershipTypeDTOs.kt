package com.mmcm.projectocp.backend.spring.application.dto

class MoaPartnershipTypeDTOs {
    data class GetResult(
        val id: String,
        val moa: String?,
        val partnershipType: String
    )

    data class PostRequest(
        val moa: String,
        val partnershipType: String
    )

    data class PutRequest(
        val moa: String?,
        val partnershipType: String?
    )
}