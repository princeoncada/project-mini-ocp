package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionProgramDTOs
import com.mmcm.projectocp.backend.spring.domain.model.MoaPositionProgram
import com.mmcm.projectocp.backend.spring.domain.repository.MoaPositionRepository
import com.mmcm.projectocp.backend.spring.domain.repository.ProgramRepository
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class MoaPositionProgramMapper(
    private val programRepository: ProgramRepository,
    private val moaPositionRepository: MoaPositionRepository
): EntityMapper<MoaPositionProgram, MoaPositionProgramDTOs.GetResult, MoaPositionProgramDTOs.PostRequest, MoaPositionProgramDTOs.PutRequest> {
    override fun toGetResult(
        entity: MoaPositionProgram
    ): MoaPositionProgramDTOs.GetResult {
        return MoaPositionProgramDTOs.GetResult(
            id = entity.id,
            program = entity.program.name,
            moaPosition = entity.moaPosition.name,
            studentsAccommodated = entity.studentsAccommodated
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MoaPositionProgramDTOs.PostRequest
    ): MoaPositionProgram {
        return MoaPositionProgram(
            id = id,
            program = programRepository.findByName(entityRequest.program).get(),
            moaPosition = moaPositionRepository.findByName(entityRequest.moaPosition).get(),
            studentsAccommodated = entityRequest.studentsAccommodated,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: MoaPositionProgram,
        entityRequest: MoaPositionProgramDTOs.PutRequest
    ): MoaPositionProgram {
        return MoaPositionProgram(
            id = entity.id,
            program = programRepository.findByName(entityRequest.program).getOrNull() ?: entity.program,
            moaPosition = moaPositionRepository.findByName(entityRequest.moaPosition).getOrNull() ?: entity.moaPosition,
            studentsAccommodated = entityRequest.studentsAccommodated ?: entity.studentsAccommodated,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}