package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.OjtDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.OjtDeliveryModeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.OjtDeliveryModeRepository
import com.mmcm.projectocp.backend.spring.domain.service.OjtDeliveryModeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class OjtDeliveryModeServiceImpl(
    private val ojtDeliveryModeRepository: OjtDeliveryModeRepository,
    private val ojtDeliveryModeMapper: OjtDeliveryModeMapper,
): OjtDeliveryModeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<OjtDeliveryModeDTOs.GetResult> {
        return ojtDeliveryModeRepository.findAll(pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<OjtDeliveryModeDTOs.GetResult> {
        val ojtDeliveryMode = ojtDeliveryModeRepository.findById(id, pageable)
        return ojtDeliveryMode.map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: OjtDeliveryModeDTOs.PostRequest,
        pageable: Pageable
    ): Page<OjtDeliveryModeDTOs.GetResult> {
        val ojtDeliveryModeId = UUID.randomUUID().toString()
        val savedOJTDeliveryMode = ojtDeliveryModeRepository.save(ojtDeliveryModeMapper.createEntity(ojtDeliveryModeId, entityRequest))
        return ojtDeliveryModeRepository.findById(savedOJTDeliveryMode.id, pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: OjtDeliveryModeDTOs.PutRequest,
        pageable: Pageable
    ): Page<OjtDeliveryModeDTOs.GetResult> {
        val currentOJTDeliveryMode = ojtDeliveryModeRepository.findById(id).get()
        val savedOJTDeliveryMode = ojtDeliveryModeRepository.save(ojtDeliveryModeMapper.updateEntity(currentOJTDeliveryMode, entityRequest))
        return ojtDeliveryModeRepository.findById(savedOJTDeliveryMode.id, pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<OjtDeliveryModeDTOs.GetResult> {
        val ojtDeliveryMode = ojtDeliveryModeRepository.findById(id).get()
        ojtDeliveryModeRepository.delete(ojtDeliveryMode)
        return ojtDeliveryModeRepository.findAll(pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }
}