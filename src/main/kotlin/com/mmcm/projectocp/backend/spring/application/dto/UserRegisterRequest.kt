package com.mmcm.projectocp.backend.spring.application.dto

data class UserRegisterRequest(
    val email: String,
    val firstName: String,
    val lastName: String,
    val studentId: String,
    val designation: String,
)
