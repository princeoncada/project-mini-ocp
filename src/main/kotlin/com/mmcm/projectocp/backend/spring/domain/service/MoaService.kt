package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaDTOs
import org.springframework.stereotype.Service

@Service
interface MoaService: EntityService<MoaDTOs.GetResult, MoaDTOs.PostRequest, MoaDTOs.PutRequest> {
}