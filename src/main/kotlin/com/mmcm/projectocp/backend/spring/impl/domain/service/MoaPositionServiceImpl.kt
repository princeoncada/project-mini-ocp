package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MoaPositionMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MoaPositionRepository
import com.mmcm.projectocp.backend.spring.domain.service.MoaPositionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MoaPositionServiceImpl(
    private val moaPositionRepository: MoaPositionRepository,
    private val moaPositionMapper: MoaPositionMapper
): MoaPositionService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MoaPositionDTOs.GetResult> {
        return moaPositionRepository.findAll(pageable).map { moaPositionMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaPositionDTOs.GetResult> {
        val moaPosition = moaPositionRepository.findById(id, pageable)
        return moaPosition.map { moaPositionMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MoaPositionDTOs.PostRequest,
        pageable: Pageable
    ): Page<MoaPositionDTOs.GetResult> {
        val moaPositionId = UUID.randomUUID().toString()
        val savedMoaPosition = moaPositionRepository.save(moaPositionMapper.createEntity(moaPositionId, entityRequest))
        return moaPositionRepository.findById(savedMoaPosition.id, pageable).map { moaPositionMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MoaPositionDTOs.PutRequest,
        pageable: Pageable
    ): Page<MoaPositionDTOs.GetResult> {
        val moaPosition = moaPositionRepository.findById(id).get()
        val savedMoaPosition = moaPositionRepository.save(moaPositionMapper.updateEntity(moaPosition, entityRequest))
        return moaPositionRepository.findById(savedMoaPosition.id, pageable).map { moaPositionMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaPositionDTOs.GetResult> {
        val moaPosition = moaPositionRepository.findById(id).get()
        moaPositionRepository.delete(moaPosition)
        return moaPositionRepository.findAll(pageable).map { moaPositionMapper.toGetResult(it) }
    }
}