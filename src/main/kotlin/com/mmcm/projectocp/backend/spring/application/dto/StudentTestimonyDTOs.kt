package com.mmcm.projectocp.backend.spring.application.dto

class StudentTestimonyDTOs {
    data class GetResult(
        val id: String,
        val studentCompaniesAttendedId: String,
        val review: String?,
        val rating: Int,
        val dateApproved: String?
    )

    data class PostRequest(
        val studentCompaniesAttendedId: String,
        val review: String?,
        val rating: Int,
        val dateApproved: String?
    )

    data class PutRequest(
        val studentCompaniesAttendedId: String?,
        val review: String?,
        val rating: Int?,
        val dateApproved: String?
    )
}