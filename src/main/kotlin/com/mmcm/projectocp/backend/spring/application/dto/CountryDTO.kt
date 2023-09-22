package com.mmcm.projectocp.backend.spring.application.dto



/**
 * DTO for {@link com.mmcm.projectocp.backend.spring.domain.model.Country}
 */
data class CountryDTO(
    val id: String?,
    val isoCode: String,
    val name: String
)