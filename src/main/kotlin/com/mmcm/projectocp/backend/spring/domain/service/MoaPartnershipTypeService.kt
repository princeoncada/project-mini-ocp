package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaPartnershipTypeDTOs
import org.springframework.stereotype.Service

@Service
interface MoaPartnershipTypeService: EntityService<MoaPartnershipTypeDTOs.GetResult, MoaPartnershipTypeDTOs.PostRequest, MoaPartnershipTypeDTOs.PutRequest> {
}