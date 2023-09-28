package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaOjtDeliveryModeDTOs
import org.springframework.stereotype.Service

@Service
interface MoaOjtDeliveryModeService: EntityService<MoaOjtDeliveryModeDTOs.GetResult, MoaOjtDeliveryModeDTOs.PostRequest, MoaOjtDeliveryModeDTOs.PutRequest> {
}