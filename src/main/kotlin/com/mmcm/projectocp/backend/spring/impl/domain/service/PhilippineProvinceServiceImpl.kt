package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineProvinceDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.PhilippineProvinceMapper
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineProvinceRepository
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineProvinceService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PhilippineProvinceServiceImpl(
    private val philippineProvinceRepository: PhilippineProvinceRepository,
    private val philippineProvinceMapper: PhilippineProvinceMapper
): PhilippineProvinceService {
    override fun getEntities(
        pageable: Pageable
    ): Page<PhilippineProvinceDTOs.GetResult> {
        return philippineProvinceRepository.findAll(pageable).map { philippineProvinceMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<PhilippineProvinceDTOs.GetResult> {
        val philippineProvince = philippineProvinceRepository.findById(id, pageable)
        return philippineProvince.map { philippineProvinceMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: PhilippineProvinceDTOs.PostRequest,
        pageable: Pageable
    ): Page<PhilippineProvinceDTOs.GetResult> {
        val philippineProvince = UUID.randomUUID().toString()
        val savedPhilippineProvince = philippineProvinceRepository.save(philippineProvinceMapper.createEntity(philippineProvince, entityRequest))
        return philippineProvinceRepository.findById(savedPhilippineProvince.id, pageable).map { philippineProvinceMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: PhilippineProvinceDTOs.PutRequest,
        pageable: Pageable
    ): Page<PhilippineProvinceDTOs.GetResult> {
        val currentPhilippineProvince = philippineProvinceRepository.findById(id).get()
        val savedPhilippineProvince = philippineProvinceRepository.save(philippineProvinceMapper.updateEntity(currentPhilippineProvince, entityRequest))
        return philippineProvinceRepository.findById(savedPhilippineProvince.id, pageable).map { philippineProvinceMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<PhilippineProvinceDTOs.GetResult> {
        val philippineProvince = philippineProvinceRepository.findById(id).get()
        philippineProvinceRepository.delete(philippineProvince)
        return philippineProvinceRepository.findAll(pageable).map { philippineProvinceMapper.toGetResult(it) }
    }
}