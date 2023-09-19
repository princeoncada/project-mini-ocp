package com.mmcm.projectocp.backend.spring.application.dto

data class UserLoginRequest(
    val email: String,
    val studentId: String,
)