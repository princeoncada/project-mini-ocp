package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PartnershipTypeDTOs
import org.springframework.stereotype.Service

@Service
interface PartnershipTypeService : EntityService<PartnershipTypeDTOs.GetResult, PartnershipTypeDTOs.PostRequest, PartnershipTypeDTOs.PutRequest> {
}