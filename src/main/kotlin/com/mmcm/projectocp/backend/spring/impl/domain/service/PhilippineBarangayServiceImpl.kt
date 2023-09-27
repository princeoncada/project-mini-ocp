package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineBarangayDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.PhilippineBarangayMapper
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineBarangayRepository
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineBarangayService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PhilippineBarangayServiceImpl(
    private val philippineBarangayRepository: PhilippineBarangayRepository,
    private val philippineBarangayMapper: PhilippineBarangayMapper
): PhilippineBarangayService{
    override fun getEntities(
        pageable: Pageable
    ): Page<PhilippineBarangayDTOs.GetResult> {
        return philippineBarangayRepository.findAll(pageable).map { philippineBarangayMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<PhilippineBarangayDTOs.GetResult> {
        val philippineBarangay = philippineBarangayRepository.findById(id, pageable)
        return philippineBarangay.map { philippineBarangayMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: PhilippineBarangayDTOs.PostRequest,
        pageable: Pageable
    ): Page<PhilippineBarangayDTOs.GetResult> {
        val philippineBarangayId = UUID.randomUUID().toString()
        val savedPhilippineBarangay = philippineBarangayRepository.save(philippineBarangayMapper.createEntity(philippineBarangayId, entityRequest))
        return philippineBarangayRepository.findById(savedPhilippineBarangay.id, pageable).map { philippineBarangayMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: PhilippineBarangayDTOs.PutRequest,
        pageable: Pageable
    ): Page<PhilippineBarangayDTOs.GetResult> {
        val currentPhilippineBarangay = philippineBarangayRepository.findById(id).get()
        val savedPhilippineBarangay = philippineBarangayRepository.save(philippineBarangayMapper.updateEntity(currentPhilippineBarangay, entityRequest))
        return philippineBarangayRepository.findById(savedPhilippineBarangay.id, pageable).map { philippineBarangayMapper.toGetResult(it) }
    }

    override fun deleteEntityById(id: String, pageable: Pageable): Page<PhilippineBarangayDTOs.GetResult> {
        val philippineBarangay = philippineBarangayRepository.findById(id).get()
        philippineBarangayRepository.delete(philippineBarangay)
        return philippineBarangayRepository.findAll(pageable).map { philippineBarangayMapper.toGetResult(it) }
    }
}