package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PartnershipTypeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.PartnershipTypeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.PartnershipTypeRepository
import com.mmcm.projectocp.backend.spring.domain.service.PartnershipTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class PartnershipTypeServiceImpl (
    private val partnershipTypeRepository: PartnershipTypeRepository,
    private val partnershipTypeMapper: PartnershipTypeMapper
): PartnershipTypeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<PartnershipTypeDTOs.GetResult> {
        return partnershipTypeRepository.findAll(pageable).map { partnershipTypeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<PartnershipTypeDTOs.GetResult> {
        val partnershipType = partnershipTypeRepository.findById(id, pageable)
        return partnershipType.map { partnershipTypeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: PartnershipTypeDTOs.PostRequest,
        pageable: Pageable
    ): Page<PartnershipTypeDTOs.GetResult> {
        val partnershipTypeId = UUID.randomUUID().toString()
        val savedPartnershipType = partnershipTypeRepository.save(partnershipTypeMapper.createEntity(partnershipTypeId, entityRequest))
        return partnershipTypeRepository.findById(savedPartnershipType.id, pageable).map { partnershipTypeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: PartnershipTypeDTOs.PutRequest,
        pageable: Pageable
    ): Page<PartnershipTypeDTOs.GetResult> {
        val currentPartnershipType = partnershipTypeRepository.findById(id).get()
        val savedPartnershipType = partnershipTypeRepository.save(partnershipTypeMapper.updateEntity(currentPartnershipType, entityRequest))
        return partnershipTypeRepository.findById(savedPartnershipType.id, pageable).map { partnershipTypeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<PartnershipTypeDTOs.GetResult> {
        val partnershipType = partnershipTypeRepository.findById(id).get()
        partnershipTypeRepository.delete(partnershipType)
        return partnershipTypeRepository.findAll(pageable).map { partnershipTypeMapper.toGetResult(it) }
    }
}