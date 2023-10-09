package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CourseDTOs
import org.springframework.stereotype.Service

@Service
interface CourseService: EntityService<CourseDTOs.GetResult, CourseDTOs.PostRequest, CourseDTOs.PutRequest> {
}