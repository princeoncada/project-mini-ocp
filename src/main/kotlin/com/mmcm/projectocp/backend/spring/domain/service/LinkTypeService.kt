package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.LinkTypeDTOs
import org.springframework.stereotype.Service

@Service
interface LinkTypeService: EntityService<LinkTypeDTOs.GetResult, LinkTypeDTOs.PostRequest, LinkTypeDTOs.PutRequest> {
}