package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Department
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class DepartmentMapper: EntityMapper<Department, DepartmentDTOs.GetResult, DepartmentDTOs.PostRequest, DepartmentDTOs.PutRequest>{
    override fun toGetResult(
        entity: Department
    ): DepartmentDTOs.GetResult {
        return DepartmentDTOs.GetResult(
            id = entity.id,
            name = entity.name,
            abbr = entity.abbr
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: DepartmentDTOs.PostRequest
    ): Department {
        return Department(
            id = id,
            name = entityRequest.name,
            abbr = entityRequest.abbr,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: Department,
        entityRequest: DepartmentDTOs.PutRequest
    ): Department {
        return Department(
            id = entity.id,
            name = entityRequest.name?: entity.name,
            abbr = entityRequest.abbr?: entity.abbr,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}