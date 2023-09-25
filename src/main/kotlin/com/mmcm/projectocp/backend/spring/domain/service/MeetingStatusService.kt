package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MeetingStatusDTOs
import org.springframework.stereotype.Service

@Service
interface MeetingStatusService: EntityService<MeetingStatusDTOs.GetResult, MeetingStatusDTOs.PostRequest, MeetingStatusDTOs.PutRequest> {
}