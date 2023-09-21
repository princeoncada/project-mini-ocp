package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.mapper.CountryMapper
import com.mmcm.projectocp.backend.spring.application.dto.CountryDto
import com.mmcm.projectocp.backend.spring.domain.repository.CountryRepository
import com.mmcm.projectocp.backend.spring.domain.service.CountryService
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
    private val countryMapper: CountryMapper
) : CountryService {
    override fun createCountry(country: CountryDto): CountryDto {
        val countryEntity = countryMapper.toEntity(country)
        val countryEntityCreated = countryRepository.save(countryEntity)
        return countryMapper.toDto(countryEntityCreated)
    }

    override fun updateCountryById(id: String, country: CountryDto): CountryDto {
        val countryEntity = countryMapper.toEntity(country)
        val countryEntityUpdated = countryRepository.save(countryEntity)
        return countryMapper.toDto(countryEntityUpdated)
    }

    override fun deleteCountryById(id: String) {
        countryRepository.deleteById(id)
    }


}