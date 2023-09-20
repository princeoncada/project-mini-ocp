package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Program
import org.springframework.data.jpa.repository.JpaRepository

interface ProgramRepository : JpaRepository<Program, String> {
    // You can add custom query methods here if needed
}
