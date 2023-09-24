package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.SessionDTOs
import org.springframework.stereotype.Service

@Service
interface SessionService: EntityService<SessionDTOs.GetResult, SessionDTOs.PostRequest, SessionDTOs.PutRequest> {
}