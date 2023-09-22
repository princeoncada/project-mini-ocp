package com.mmcm.projectocp.backend.spring.application.dto

import java.util.UUID

/**
 * DTO for {@link com.mmcm.projectocp.backend.spring.domain.model.Department}
 */
data class DepartmentDTO(
    val id: String? = UUID.randomUUID().toString(),
    val name: String,
    val abbr: String
)
