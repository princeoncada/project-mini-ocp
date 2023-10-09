package com.mmcm.projectocp.backend.spring.application.dto

class RequirementSubmissionDTOs {
    data class GetResult(
        val id: String,
        val user: String,
        val studentCourse: String,
        val requirement: String,
        val status: Int,
        val message: String?
    )

    data class PostRequest(
        val user: String,
        val studentCourse: String,
        val requirement: String,
        val status: Int,
        val message: String?
    )

    data class PutRequest(
        val user: String?,
        val studentCourse: String?,
        val requirement: String?,
        val status: Int?,
        val message: String?
    )
}