package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.StudentCourseDTOs
import org.springframework.stereotype.Service

@Service
interface StudentCourseService: EntityService<StudentCourseDTOs.GetResult, StudentCourseDTOs.PostRequest, StudentCourseDTOs.PutRequest> {
}