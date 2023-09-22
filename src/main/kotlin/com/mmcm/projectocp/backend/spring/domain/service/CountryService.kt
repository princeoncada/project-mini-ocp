package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CountryDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
interface CountryService {

    fun createCountry(country: CountryDTO): CountryDTO

    fun updateCountryById(id: String, country: CountryDTO): CountryDTO

    fun deleteCountryById(id: String)
}