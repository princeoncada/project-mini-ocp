package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaPartnershipTypeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MoaPartnershipTypeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MoaPartnershipTypeRepository
import com.mmcm.projectocp.backend.spring.domain.service.MoaPartnershipTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MoaPartnershipTypeServiceImpl(
    private val moaPartnershipTypeRepository: MoaPartnershipTypeRepository,
    private val moaPartnershipTypeMapper: MoaPartnershipTypeMapper
): MoaPartnershipTypeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MoaPartnershipTypeDTOs.GetResult> {
        return moaPartnershipTypeRepository.findAll(pageable).map { moaPartnershipTypeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaPartnershipTypeDTOs.GetResult> {
        val moaPartnershipType = moaPartnershipTypeRepository.findById(id, pageable)
        return moaPartnershipType.map { moaPartnershipTypeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MoaPartnershipTypeDTOs.PostRequest,
        pageable: Pageable
    ): Page<MoaPartnershipTypeDTOs.GetResult> {
        val moaPartnershipTypeId = UUID.randomUUID().toString()
        val savedMoaPartnershipType = moaPartnershipTypeRepository.save(moaPartnershipTypeMapper.createEntity(moaPartnershipTypeId, entityRequest))
        return moaPartnershipTypeRepository.findById(savedMoaPartnershipType.id, pageable).map { moaPartnershipTypeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MoaPartnershipTypeDTOs.PutRequest,
        pageable: Pageable
    ): Page<MoaPartnershipTypeDTOs.GetResult> {
        val moaPartnershipType = moaPartnershipTypeRepository.findById(id).get()
        val savedMoaPartnershipType = moaPartnershipTypeRepository.save(moaPartnershipTypeMapper.updateEntity(moaPartnershipType, entityRequest))
        return moaPartnershipTypeRepository.findById(savedMoaPartnershipType.id, pageable).map { moaPartnershipTypeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaPartnershipTypeDTOs.GetResult> {
        val moaPartnershipType = moaPartnershipTypeRepository.findById(id).get()
        moaPartnershipTypeRepository.delete(moaPartnershipType)
        return moaPartnershipTypeRepository.findAll(pageable).map { moaPartnershipTypeMapper.toGetResult(it) }
    }
}