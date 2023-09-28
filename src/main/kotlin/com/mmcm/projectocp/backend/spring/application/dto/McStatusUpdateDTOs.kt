package com.mmcm.projectocp.backend.spring.application.dto

class McStatusUpdateDTOs {
    data class GetResult(
        val id: String,
        val mcStatus: String,
        val moa: String?,
        val notes: String?,
        val mcApprovedDate: String,
    )

    data class PostRequest(
        val mcStatus: String,
        val moa: String,
        val notes: String?,
        val mcApprovedDate: String?,
    )

    data class PutRequest(
        val mcStatus: String?,
        val moa: String?,
        val notes: String?,
        val mcApprovedDate: String?,
    )
}