package com.mmcm.projectocp.backend.spring.application.dto

class StudentCourseDTOs {
    data class GetResult(
        val id: String,
        val course: String,
        val user: String?,
        val adviser: String?,
        val program: String,
        val email: String,
        val studentId: String,
        val isFinished: Boolean?,
    )

    data class PostRequest(
        val course: String,
        val user: String?,
        val adviser: String?,
        val program: String,
        val email: String,
        val studentId: String,
        val isFinished: Boolean?,
    )

    data class PutRequest(
        val course: String?,
        val user: String?,
        val adviser: String?,
        val program: String?,
        val email: String?,
        val studentId: String?,
        val isFinished: Boolean?,
    )
}