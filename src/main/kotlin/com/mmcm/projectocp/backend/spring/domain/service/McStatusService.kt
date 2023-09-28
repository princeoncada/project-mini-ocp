package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.McStatusDTOs
import org.springframework.stereotype.Service

@Service
interface McStatusService: EntityService<McStatusDTOs.GetResult, McStatusDTOs.PostRequest, McStatusDTOs.PutRequest> {
}