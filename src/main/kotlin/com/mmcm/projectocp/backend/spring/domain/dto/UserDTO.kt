package com.mmcm.projectocp.backend.spring.domain.dto

import java.time.Instant

data class UserDTO(
    val id: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val studentId: String,
    val designation: String,
)