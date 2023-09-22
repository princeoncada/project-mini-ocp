package com.mmcm.projectocp.backend.spring.application.dto

class UserDTOs{
    data class GetResult(
        val id: String,
        val email: String,
        val firstName: String,
        val lastName: String,
        val studentId: String,
        val designation: String
    )

    data class PostRequest(
        val email: String,
        val firstName: String,
        val lastName: String,
        val studentId: String,
        val designation: String
    )

    data class PutRequest(
        val email: String?,
        val firstName: String?,
        val lastName: String?,
        val studentId: String?,
        val designation: String?
    )
}



