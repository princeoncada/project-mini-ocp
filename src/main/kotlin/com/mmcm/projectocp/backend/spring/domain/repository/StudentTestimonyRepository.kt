package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.StudentTestimony
import org.springframework.data.jpa.repository.JpaRepository

interface StudentTestimonyRepository : JpaRepository<StudentTestimony, String> {
    // You can add custom query methods here if needed
}
