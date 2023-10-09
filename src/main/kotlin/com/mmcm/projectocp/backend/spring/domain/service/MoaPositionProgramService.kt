package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionProgramDTOs
import org.springframework.stereotype.Service

@Service
interface MoaPositionProgramService: EntityService<MoaPositionProgramDTOs.GetResult, MoaPositionProgramDTOs.PostRequest, MoaPositionProgramDTOs.PutRequest> {
}