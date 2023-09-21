package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CountryDto
import com.mmcm.projectocp.backend.spring.domain.model.Country
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
interface CountryService {

    fun createCountry(country: CountryDto): CountryDto

    fun updateCountryById(id: String, country: CountryDto): CountryDto

    fun deleteCountryById(id: String)
}