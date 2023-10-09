package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.TermDTOs
import org.springframework.stereotype.Service

@Service
interface TermService: EntityService<TermDTOs.GetResult, TermDTOs.PostRequest, TermDTOs.PutRequest> {
}