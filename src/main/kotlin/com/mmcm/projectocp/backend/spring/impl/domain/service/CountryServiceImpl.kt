package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CountryDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.CountryMapper
import com.mmcm.projectocp.backend.spring.domain.repository.CountryRepository
import com.mmcm.projectocp.backend.spring.domain.service.CountryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
    private val countryMapper: CountryMapper

) : CountryService {
    override fun getEntities(pageable: Pageable): Page<CountryDTOs.GetResult> {
        return countryRepository.findAll(pageable).map { countryMapper.toGetResult(it) }
    }

    override fun getEntityById(id: String, pageable: Pageable): Page<CountryDTOs.GetResult> {
        val country = countryRepository.findById(id, pageable)
        return country.map { countryMapper.toGetResult(it) }
    }

    override fun createEntity(entityRequest: CountryDTOs.PostRequest, pageable: Pageable): Page<CountryDTOs.GetResult> {
        val countryId = UUID.randomUUID().toString()
        countryRepository.save(countryMapper.createEntity(countryId, entityRequest))
        return countryRepository.findById(countryId, pageable).map { countryMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: CountryDTOs.PutRequest,
        pageable: Pageable
    ): Page<CountryDTOs.GetResult> {
        val currentCountry = countryRepository.findById(id).get()
        countryRepository.save(countryMapper.updateEntity(currentCountry, entityRequest))
        return countryRepository.findById(id, pageable).map { countryMapper.toGetResult(it) }
    }

    override fun deleteEntityById(id: String, pageable: Pageable): Page<CountryDTOs.GetResult> {
        val country = countryRepository.findById(id).get()
        countryRepository.delete(country)
        return countryRepository.findAll(pageable).map { countryMapper.toGetResult(it) }
    }
}