package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.OJTDeliveryModeDTOs
import org.springframework.stereotype.Service

@Service
interface OjtDeliveryModeService: EntityService<OJTDeliveryModeDTOs.GetResult, OJTDeliveryModeDTOs.PostRequest, OJTDeliveryModeDTOs.PutRequest> {
}