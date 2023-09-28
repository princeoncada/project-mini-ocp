package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MeetingDTOs
import org.springframework.stereotype.Service

@Service
interface MeetingService: EntityService<MeetingDTOs.GetResult, MeetingDTOs.PostRequest, MeetingDTOs.PutRequest> {
}