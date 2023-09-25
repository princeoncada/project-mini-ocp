package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.OJTDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.OJTDeliveryModeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.OJTDeliveryModeRepository
import com.mmcm.projectocp.backend.spring.domain.service.OJTDeliveryModeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class OJTDeliveryModeServiceImpl(
    private val ojtDeliveryModeRepository: OJTDeliveryModeRepository,
    private val ojtDeliveryModeMapper: OJTDeliveryModeMapper,
): OJTDeliveryModeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<OJTDeliveryModeDTOs.GetResult> {
        return ojtDeliveryModeRepository.findAll(pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<OJTDeliveryModeDTOs.GetResult> {
        val ojtDeliveryMode = ojtDeliveryModeRepository.findById(id, pageable)
        return ojtDeliveryMode.map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: OJTDeliveryModeDTOs.PostRequest,
        pageable: Pageable
    ): Page<OJTDeliveryModeDTOs.GetResult> {
        val ojtDeliveryModeId = UUID.randomUUID().toString()
        val savedOJTDeliveryMode = ojtDeliveryModeRepository.save(ojtDeliveryModeMapper.createEntity(ojtDeliveryModeId, entityRequest))
        return ojtDeliveryModeRepository.findById(savedOJTDeliveryMode.id, pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: OJTDeliveryModeDTOs.PutRequest,
        pageable: Pageable
    ): Page<OJTDeliveryModeDTOs.GetResult> {
        val currentOJTDeliveryMode = ojtDeliveryModeRepository.findById(id).get()
        val savedOJTDeliveryMode = ojtDeliveryModeRepository.save(ojtDeliveryModeMapper.updateEntity(currentOJTDeliveryMode, entityRequest))
        return ojtDeliveryModeRepository.findById(savedOJTDeliveryMode.id, pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<OJTDeliveryModeDTOs.GetResult> {
        val ojtDeliveryMode = ojtDeliveryModeRepository.findById(id).get()
        ojtDeliveryModeRepository.delete(ojtDeliveryMode)
        return ojtDeliveryModeRepository.findAll(pageable).map { ojtDeliveryModeMapper.toGetResult(it) }
    }
}