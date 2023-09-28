package com.mmcm.projectocp.backend.spring.application.dto

class MoaDTOs {
    data class GetResult(
        val id: String,
        val branch: String,
        val title: String?,
        val startDate: String?,
        val expiryDate: String?,
        val description: String?,
        val vpaaSubmission: String?,
        val isActive: String,
        val isHiring: String,
    )

    data class PostRequest(
        val branch: String,
        val title: String?,
        val startDate: String?,
        val expiryDate: String?,
        val description: String?,
        val vpaaSubmission: String?,
        val isActive: String,
        val isHiring: String,
    )

    data class PutRequest(
        val branch: String?,
        val title: String?,
        val startDate: String?,
        val expiryDate: String?,
        val description: String?,
        val vpaaSubmission: String?,
        val isActive: String?,
        val isHiring: String?,
    )
}