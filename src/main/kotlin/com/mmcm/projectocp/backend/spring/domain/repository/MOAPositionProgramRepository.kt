package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MOAPositionProgram
import org.springframework.data.jpa.repository.JpaRepository

interface MOAPositionProgramRepository : JpaRepository<MOAPositionProgram, String> {
    // You can add custom query methods here if needed
}
