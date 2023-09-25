package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.StudentCompanyAttendance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentCompanyAttendedRepository: JpaRepository<StudentCompanyAttendance, String> {
}
