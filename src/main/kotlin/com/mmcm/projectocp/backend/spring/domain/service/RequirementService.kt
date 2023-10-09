package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RequirementDTOs
import org.springframework.stereotype.Service

@Service
interface RequirementService: EntityService<RequirementDTOs.GetResult, RequirementDTOs.PostRequest, RequirementDTOs.PutRequest> {
}