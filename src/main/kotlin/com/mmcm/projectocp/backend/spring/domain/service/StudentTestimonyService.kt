package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.StudentTestimonyDTOs
import org.springframework.stereotype.Service

@Service
interface StudentTestimonyService: EntityService<StudentTestimonyDTOs.GetResult, StudentTestimonyDTOs.PostRequest, StudentTestimonyDTOs.PutRequest> {
}