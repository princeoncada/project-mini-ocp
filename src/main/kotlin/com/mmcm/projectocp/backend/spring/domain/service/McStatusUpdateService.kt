package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.McStatusUpdateDTOs
import org.springframework.stereotype.Service

@Service
interface McStatusUpdateService: EntityService<McStatusUpdateDTOs.GetResult, McStatusUpdateDTOs.PostRequest, McStatusUpdateDTOs.PutRequest> {
}