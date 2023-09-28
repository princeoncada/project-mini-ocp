package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.McStatusUpdateDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.McStatusUpdateMapper
import com.mmcm.projectocp.backend.spring.domain.repository.McStatusUpdateRepository
import com.mmcm.projectocp.backend.spring.domain.service.McStatusUpdateService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class McStatusUpdateServiceImpl(
    private val mcStatusUpdateRepository: McStatusUpdateRepository,
    private val mcStatusUpdateMapper: McStatusUpdateMapper
): McStatusUpdateService {
    override fun getEntities(
        pageable: Pageable
    ): Page<McStatusUpdateDTOs.GetResult> {
        return mcStatusUpdateRepository.findAll(pageable).map { mcStatusUpdateMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<McStatusUpdateDTOs.GetResult> {
        val mcStatusUpdate = mcStatusUpdateRepository.findById(id, pageable)
        return mcStatusUpdate.map { mcStatusUpdateMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: McStatusUpdateDTOs.PostRequest,
        pageable: Pageable
    ): Page<McStatusUpdateDTOs.GetResult> {
        val mcStatusUpdateId = UUID.randomUUID().toString()
        val savedMcStatusUpdate = mcStatusUpdateRepository.save(mcStatusUpdateMapper.createEntity(mcStatusUpdateId, entityRequest))
        return mcStatusUpdateRepository.findById(savedMcStatusUpdate.id, pageable).map { mcStatusUpdateMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: McStatusUpdateDTOs.PutRequest,
        pageable: Pageable
    ): Page<McStatusUpdateDTOs.GetResult> {
        val mcStatusUpdate = mcStatusUpdateRepository.findById(id).get()
        val savedMcStatusUpdate = mcStatusUpdateRepository.save(mcStatusUpdateMapper.updateEntity(mcStatusUpdate, entityRequest))
        return mcStatusUpdateRepository.findById(savedMcStatusUpdate.id, pageable).map { mcStatusUpdateMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<McStatusUpdateDTOs.GetResult> {
        val mcStatusUpdate = mcStatusUpdateRepository.findById(id).get()
        mcStatusUpdateRepository.delete(mcStatusUpdate)
        return mcStatusUpdateRepository.findAll(pageable).map { mcStatusUpdateMapper.toGetResult(it) }
    }
}