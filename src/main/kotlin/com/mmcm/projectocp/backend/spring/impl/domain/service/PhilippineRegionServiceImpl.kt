package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineRegionDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.PhilippineRegionMapper
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineRegionRepository
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineRegionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PhilippineRegionServiceImpl(
    private val philippineRegionRepository: PhilippineRegionRepository,
    private val philippineRegionMapper: PhilippineRegionMapper,
): PhilippineRegionService {
    override fun getEntities(
        pageable: Pageable
    ): Page<PhilippineRegionDTOs.GetResult> {
        return philippineRegionRepository.findAll(pageable).map { philippineRegionMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<PhilippineRegionDTOs.GetResult> {
        val philippineRegion = philippineRegionRepository.findById(id, pageable)
        return philippineRegion.map { philippineRegionMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: PhilippineRegionDTOs.PostRequest,
        pageable: Pageable
    ): Page<PhilippineRegionDTOs.GetResult> {
        val philippineRegionId = UUID.randomUUID().toString()
        val savedPhilippineRegion = philippineRegionRepository.save(philippineRegionMapper.createEntity(philippineRegionId, entityRequest))
        return philippineRegionRepository.findById(savedPhilippineRegion.id, pageable).map { philippineRegionMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: PhilippineRegionDTOs.PutRequest,
        pageable: Pageable
    ): Page<PhilippineRegionDTOs.GetResult> {
        val currentPhilippineRegion = philippineRegionRepository.findById(id).get()
        val savedPhilippineRegion = philippineRegionRepository.save(philippineRegionMapper.updateEntity(currentPhilippineRegion, entityRequest))
        return philippineRegionRepository.findById(savedPhilippineRegion.id, pageable).map { philippineRegionMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<PhilippineRegionDTOs.GetResult> {
        val philippineRegion = philippineRegionRepository.findById(id).get()
        philippineRegionRepository.delete(philippineRegion)
        return philippineRegionRepository.findAll(pageable).map { philippineRegionMapper.toGetResult(it) }
    }
}