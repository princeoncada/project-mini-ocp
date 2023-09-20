package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.StudentCompanyAttendance
import org.springframework.data.jpa.repository.JpaRepository

interface StudentCompanyAttendedRepository : JpaRepository<StudentCompanyAttendance, String> {
    // You can add custom query methods here if needed
}
