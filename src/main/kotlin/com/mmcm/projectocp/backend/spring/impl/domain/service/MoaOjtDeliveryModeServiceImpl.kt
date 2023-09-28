package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaOjtDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MoaOjtDeliveryModeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MoaOjtDeliveryModeRepository
import com.mmcm.projectocp.backend.spring.domain.service.MoaOjtDeliveryModeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MoaOjtDeliveryModeServiceImpl(
    private val moaOjtDeliveryModeRepository: MoaOjtDeliveryModeRepository,
    private val moaOjtDeliveryModeMapper: MoaOjtDeliveryModeMapper
): MoaOjtDeliveryModeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MoaOjtDeliveryModeDTOs.GetResult> {
        return moaOjtDeliveryModeRepository.findAll(pageable).map { moaOjtDeliveryModeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaOjtDeliveryModeDTOs.GetResult> {
        val moaOjtDeliveryMode = moaOjtDeliveryModeRepository.findById(id, pageable)
        return moaOjtDeliveryMode.map { moaOjtDeliveryModeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MoaOjtDeliveryModeDTOs.PostRequest,
        pageable: Pageable
    ): Page<MoaOjtDeliveryModeDTOs.GetResult> {
        val moaOjtDeliveryModeId = UUID.randomUUID().toString()
        val savedMoaOjtDeliveryMode = moaOjtDeliveryModeRepository.save(moaOjtDeliveryModeMapper.createEntity(moaOjtDeliveryModeId, entityRequest))
        return moaOjtDeliveryModeRepository.findById(savedMoaOjtDeliveryMode.id, pageable).map { moaOjtDeliveryModeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MoaOjtDeliveryModeDTOs.PutRequest,
        pageable: Pageable
    ): Page<MoaOjtDeliveryModeDTOs.GetResult> {
        val moaOjtDeliveryMode = moaOjtDeliveryModeRepository.findById(id).get()
        val savedMoaOjtDeliveryMode = moaOjtDeliveryModeRepository.save(moaOjtDeliveryModeMapper.updateEntity(moaOjtDeliveryMode, entityRequest))
        return moaOjtDeliveryModeRepository.findById(savedMoaOjtDeliveryMode.id, pageable).map { moaOjtDeliveryModeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaOjtDeliveryModeDTOs.GetResult> {
        val moaOjtDeliveryMode = moaOjtDeliveryModeRepository.findById(id).get()
        moaOjtDeliveryModeRepository.delete(moaOjtDeliveryMode)
        return moaOjtDeliveryModeRepository.findAll(pageable).map { moaOjtDeliveryModeMapper.toGetResult(it) }
    }
}