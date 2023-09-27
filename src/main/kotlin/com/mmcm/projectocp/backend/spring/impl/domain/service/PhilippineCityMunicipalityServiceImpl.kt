package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineCityMunicipalityDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.PhilippineCityMunicipalityMapper
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineCityMunicipalityRepository
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineCityMunicipalityService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PhilippineCityMunicipalityServiceImpl(
    private val philippineCityMunicipalityRepository: PhilippineCityMunicipalityRepository,
    private val philippineCityMunicipalityMapper: PhilippineCityMunicipalityMapper
): PhilippineCityMunicipalityService {
    override fun getEntities(
        pageable: Pageable
    ): Page<PhilippineCityMunicipalityDTOs.GetResult> {
        return philippineCityMunicipalityRepository.findAll(pageable).map { philippineCityMunicipalityMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<PhilippineCityMunicipalityDTOs.GetResult> {
        val philippineCityMunicipality = philippineCityMunicipalityRepository.findById(id, pageable)
        return philippineCityMunicipality.map { philippineCityMunicipalityMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: PhilippineCityMunicipalityDTOs.PostRequest,
        pageable: Pageable
    ): Page<PhilippineCityMunicipalityDTOs.GetResult> {
        val philippineCityMunicipality = UUID.randomUUID().toString()
        val savedPhilippineCityMunicipality = philippineCityMunicipalityRepository.save(philippineCityMunicipalityMapper.createEntity(philippineCityMunicipality, entityRequest))
        return philippineCityMunicipalityRepository.findById(savedPhilippineCityMunicipality.id, pageable).map { philippineCityMunicipalityMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: PhilippineCityMunicipalityDTOs.PutRequest,
        pageable: Pageable
    ): Page<PhilippineCityMunicipalityDTOs.GetResult> {
        val currentPhilippineCityMunicipality = philippineCityMunicipalityRepository.findById(id).get()
        val savedPhilippineCityMunicipality = philippineCityMunicipalityRepository.save(philippineCityMunicipalityMapper.updateEntity(currentPhilippineCityMunicipality, entityRequest))
        return philippineCityMunicipalityRepository.findById(savedPhilippineCityMunicipality.id, pageable).map { philippineCityMunicipalityMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<PhilippineCityMunicipalityDTOs.GetResult> {
        val philippineCityMunicipality = philippineCityMunicipalityRepository.findById(id).get()
        philippineCityMunicipalityRepository.delete(philippineCityMunicipality)
        return philippineCityMunicipalityRepository.findAll(pageable).map { philippineCityMunicipalityMapper.toGetResult(it) }
    }
}