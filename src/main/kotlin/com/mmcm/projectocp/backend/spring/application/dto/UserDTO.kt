package com.mmcm.projectocp.backend.spring.application.dto

data class UserDTO(
    val id: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val studentId: String,
    val designation: String,
)