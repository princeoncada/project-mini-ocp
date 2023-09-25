package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.ProgramDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Program
import com.mmcm.projectocp.backend.spring.domain.repository.DepartmentRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class ProgramMapper (
    private val departmentRepository: DepartmentRepository
): EntityMapper<Program, ProgramDTOs.GetResult, ProgramDTOs.PostRequest, ProgramDTOs.PutRequest> {
    override fun toGetResult(
        entity: Program
    ): ProgramDTOs.GetResult {
        return ProgramDTOs.GetResult(
            id = entity.id,
            department= entity.department.name,
            name = entity.name,
            abbr = entity.abbr
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: ProgramDTOs.PostRequest
    ): Program {
        return Program(
            id = id,
            department = departmentRepository.findByName(entityRequest.department).get(),
            name = entityRequest.name,
            abbr = entityRequest.abbr,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Program,
        entityRequest: ProgramDTOs.PutRequest
    ): Program {
        return Program(
            id = entity.id,
            department = departmentRepository.findByName(entityRequest.department
                ?: entity.department.name).get(),
            name = entityRequest.name ?: entity.name,
            abbr = entityRequest.abbr ?: entity.abbr,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}
