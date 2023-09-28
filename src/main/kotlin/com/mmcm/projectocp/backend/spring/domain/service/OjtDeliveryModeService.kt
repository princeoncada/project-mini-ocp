package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.OjtDeliveryModeDTOs
import org.springframework.stereotype.Service

@Service
interface OjtDeliveryModeService: EntityService<OjtDeliveryModeDTOs.GetResult, OjtDeliveryModeDTOs.PostRequest, OjtDeliveryModeDTOs.PutRequest> {
}