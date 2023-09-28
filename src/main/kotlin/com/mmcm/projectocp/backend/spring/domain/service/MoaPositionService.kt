package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionDTOs
import org.springframework.stereotype.Service

@Service
interface MoaPositionService: EntityService<MoaPositionDTOs.GetResult, MoaPositionDTOs.PostRequest, MoaPositionDTOs.PutRequest> {
}