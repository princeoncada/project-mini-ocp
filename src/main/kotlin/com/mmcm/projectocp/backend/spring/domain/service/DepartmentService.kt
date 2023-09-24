package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTOs
import org.springframework.stereotype.Service

@Service
interface DepartmentService : EntityService<DepartmentDTOs.GetResult, DepartmentDTOs.PostRequest,DepartmentDTOs.PutRequest> {
}