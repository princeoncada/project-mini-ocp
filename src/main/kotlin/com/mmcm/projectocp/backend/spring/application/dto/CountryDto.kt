package com.mmcm.projectocp.backend.spring.application.dto

import java.io.Serializable

/**
 * DTO for {@link com.mmcm.projectocp.backend.spring.domain.model.Country}
 */
data class CountryDto(
    val isoCode: String,
    val name: String
)