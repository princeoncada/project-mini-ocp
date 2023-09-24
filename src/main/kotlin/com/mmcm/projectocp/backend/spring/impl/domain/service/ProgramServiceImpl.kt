package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.ProgramDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.ProgramMapper
import com.mmcm.projectocp.backend.spring.domain.repository.ProgramRepository
import com.mmcm.projectocp.backend.spring.domain.service.ProgramService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProgramServiceImpl(
    private val programRepository: ProgramRepository,
    private val programMapper: ProgramMapper
) : ProgramService {
    override fun getEntities(pageable: Pageable): Page<ProgramDTOs.GetResult> {
        return programRepository.findAll(pageable).map { programMapper.toGetResult(it) }

    }

    override fun getEntityById(id: String, pageable: Pageable): Page<ProgramDTOs.GetResult> {
        val program = programRepository.findById(id, pageable)
        return program.map { programMapper.toGetResult(it) }
    }

    override fun createEntity(entityRequest: ProgramDTOs.PostRequest, pageable: Pageable): Page<ProgramDTOs.GetResult> {
        val programId = UUID.randomUUID().toString()
        programRepository.save(programMapper.createEntity(programId, entityRequest))
        return programRepository.findById(programId, pageable).map { programMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: ProgramDTOs.PutRequest,
        pageable: Pageable
    ): Page<ProgramDTOs.GetResult> {
        val currentProgram = programRepository.findById(id).get()
        programRepository.save(programMapper.updateEntity(currentProgram, entityRequest))
        return programRepository.findById(id, pageable).map { programMapper.toGetResult(it) }
    }

    override fun deleteEntityById(id: String, pageable: Pageable): Page<ProgramDTOs.GetResult> {
        val program = programRepository.findById(id).get()
        programRepository.delete(program)
        return programRepository.findAll(pageable).map { programMapper.toGetResult(it) }
    }
}