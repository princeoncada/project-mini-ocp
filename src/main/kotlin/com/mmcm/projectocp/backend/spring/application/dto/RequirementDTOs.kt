package com.mmcm.projectocp.backend.spring.application.dto

class RequirementDTOs {
    data class GetResult(
        val id: String,
        val course: String,
        val isVisible: Boolean,
        val title: String,
        val instructions: String?,
    )

    data class PostRequest(
        val course: String,
        val isVisible: Boolean,
        val title: String,
        val instructions: String?,
    )

    data class PutRequest(
        val course: String?,
        val isVisible: Boolean?,
        val title: String?,
        val instructions: String?,
    )
}