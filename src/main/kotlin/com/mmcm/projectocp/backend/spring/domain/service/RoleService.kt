package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RoleDTOs
import org.springframework.stereotype.Service

@Service
interface RoleService: EntityService<RoleDTOs.GetResult, RoleDTOs.PostRequest, RoleDTOs.PutRequest> {
}