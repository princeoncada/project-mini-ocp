package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PermissionDTOs
import org.springframework.stereotype.Service

@Service
interface PermissionService: EntityService<PermissionDTOs.GetResult, PermissionDTOs.PostRequest, PermissionDTOs.PutRequest> {
}