package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.ProgramDTOs
import org.springframework.stereotype.Service

@Service
interface ProgramService: EntityService<ProgramDTOs.GetResult, ProgramDTOs.PostRequest, ProgramDTOs.PutRequest> {
}