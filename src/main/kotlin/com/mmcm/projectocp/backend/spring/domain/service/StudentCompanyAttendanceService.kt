package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.StudentCompanyAttendanceDTOs
import org.springframework.stereotype.Service

@Service
interface StudentCompanyAttendanceService: EntityService<StudentCompanyAttendanceDTOs.GetResult, StudentCompanyAttendanceDTOs.PostRequest, StudentCompanyAttendanceDTOs.PutRequest> {
}