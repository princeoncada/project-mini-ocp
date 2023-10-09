package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionProgramDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MoaPositionProgramMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MoaPositionProgramRepository
import com.mmcm.projectocp.backend.spring.domain.service.MoaPositionProgramService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class MoaPositionProgramServiceImpl(
    private val moaPositionProgramRepository: MoaPositionProgramRepository,
    private val moaPositionProgramMapper: MoaPositionProgramMapper
): MoaPositionProgramService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MoaPositionProgramDTOs.GetResult> {
        return moaPositionProgramRepository.findAll(pageable).map { moaPositionProgramMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaPositionProgramDTOs.GetResult> {
        val moaPositionProgram = moaPositionProgramRepository.findById(id, pageable)
        return moaPositionProgram.map { moaPositionProgramMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MoaPositionProgramDTOs.PostRequest,
        pageable: Pageable
    ): Page<MoaPositionProgramDTOs.GetResult> {
        val moaPositionProgramId = UUID.randomUUID().toString()
        val savedMoaPositionProgram = moaPositionProgramRepository.save(moaPositionProgramMapper.createEntity(moaPositionProgramId, entityRequest))
        return moaPositionProgramRepository.findById(savedMoaPositionProgram.id, pageable).map { moaPositionProgramMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MoaPositionProgramDTOs.PutRequest,
        pageable: Pageable
    ): Page<MoaPositionProgramDTOs.GetResult> {
        val moaPositionProgram = moaPositionProgramRepository.findById(id).get()
        val savedMoaPositionProgram = moaPositionProgramRepository.save(moaPositionProgramMapper.updateEntity(moaPositionProgram, entityRequest))
        return moaPositionProgramRepository.findById(savedMoaPositionProgram.id, pageable).map { moaPositionProgramMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaPositionProgramDTOs.GetResult> {
        val moaPositionProgram = moaPositionProgramRepository.findById(id).get()
        moaPositionProgramRepository.delete(moaPositionProgram)
        return moaPositionProgramRepository.findAll(pageable).map { moaPositionProgramMapper.toGetResult(it) }
    }
}