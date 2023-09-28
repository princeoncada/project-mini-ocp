package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.McStatusDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.McStatusMapper
import com.mmcm.projectocp.backend.spring.domain.repository.McStatusRepository
import com.mmcm.projectocp.backend.spring.domain.service.McStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class McStatusServiceImpl (
    private val mcStatusRepository: McStatusRepository,
    private val mcStatusMapper: McStatusMapper
): McStatusService {
    override fun getEntities(
        pageable: Pageable
    ): Page<McStatusDTOs.GetResult> {
        return mcStatusRepository.findAll(pageable).map { mcStatusMapper.toGetResult(it)}
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<McStatusDTOs.GetResult> {
        val mcStatus = mcStatusRepository.findById(id, pageable)
        return mcStatus.map { mcStatusMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: McStatusDTOs.PostRequest,
        pageable: Pageable
    ): Page<McStatusDTOs.GetResult> {
        val mcStatus = UUID.randomUUID().toString()
        val savedMCStatus = mcStatusRepository.save(mcStatusMapper.createEntity(mcStatus, entityRequest))
        return mcStatusRepository.findById(savedMCStatus.id, pageable).map { mcStatusMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: McStatusDTOs.PutRequest,
        pageable: Pageable
    ): Page<McStatusDTOs.GetResult> {
        val currentMCStatus = mcStatusRepository.findById(id).get()
        val savedMCStatus = mcStatusRepository.save(mcStatusMapper.updateEntity(currentMCStatus, entityRequest))
        return mcStatusRepository.findById(savedMCStatus.id, pageable).map { mcStatusMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<McStatusDTOs.GetResult> {
        val mcStatus = mcStatusRepository.findById(id).get()
        mcStatusRepository.delete(mcStatus)
        return mcStatusRepository.findAll(pageable).map { mcStatusMapper.toGetResult(it) }
    }
}