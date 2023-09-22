package com.mmcm.projectocp.backend.spring.application.dto



/**
 * DTO for {@link com.mmcm.projectocp.backend.spring.domain.model.AcademicYear}
 */
data class AcademicYearDTO(
    val id: String?,
    val yearFrom: Int,
    val yearTo: Int
)