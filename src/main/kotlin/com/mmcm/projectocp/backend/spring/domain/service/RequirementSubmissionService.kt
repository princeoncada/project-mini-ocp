package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RequirementSubmissionDTOs
import org.springframework.stereotype.Service

@Service
interface RequirementSubmissionService: EntityService<RequirementSubmissionDTOs.GetResult, RequirementSubmissionDTOs.PostRequest, RequirementSubmissionDTOs.PutRequest> {
}