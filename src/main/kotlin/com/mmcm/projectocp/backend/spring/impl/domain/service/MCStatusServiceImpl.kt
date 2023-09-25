package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MCStatusDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MCStatusMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MCStatusRepository
import com.mmcm.projectocp.backend.spring.domain.service.MCStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class MCStatusServiceImpl (
    private val mcStatusRepository: MCStatusRepository,
    private val mcStatusMapper: MCStatusMapper
): MCStatusService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MCStatusDTOs.GetResult> {
        return mcStatusRepository.findAll(pageable).map { mcStatusMapper.toGetResult(it)}
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MCStatusDTOs.GetResult> {
        val mcStatus = mcStatusRepository.findById(id, pageable)
        return mcStatus.map { mcStatusMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MCStatusDTOs.PostRequest,
        pageable: Pageable
    ): Page<MCStatusDTOs.GetResult> {
        val mcStatus = UUID.randomUUID().toString()
        val savedMCStatus = mcStatusRepository.save(mcStatusMapper.createEntity(mcStatus, entityRequest))
        return mcStatusRepository.findById(savedMCStatus.id, pageable).map { mcStatusMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MCStatusDTOs.PutRequest,
        pageable: Pageable
    ): Page<MCStatusDTOs.GetResult> {
        val currentMCStatus = mcStatusRepository.findById(id).get()
        val savedMCStatus = mcStatusRepository.save(mcStatusMapper.updateEntity(currentMCStatus, entityRequest))
        return mcStatusRepository.findById(savedMCStatus.id, pageable).map { mcStatusMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MCStatusDTOs.GetResult> {
        val mcStatus = mcStatusRepository.findById(id).get()
        mcStatusRepository.delete(mcStatus)
        return mcStatusRepository.findAll(pageable).map { mcStatusMapper.toGetResult(it) }
    }
}