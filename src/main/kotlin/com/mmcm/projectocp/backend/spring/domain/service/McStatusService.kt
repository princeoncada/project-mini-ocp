package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MCStatusDTOs
import org.springframework.stereotype.Service

@Service
interface McStatusService: EntityService<MCStatusDTOs.GetResult, MCStatusDTOs.PostRequest, MCStatusDTOs.PutRequest> {
}