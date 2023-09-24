package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MeetingTypeDTOs
import org.springframework.stereotype.Service

@Service
interface MeetingTypeService : EntityService<MeetingTypeDTOs.GetResult, MeetingTypeDTOs.PostRequest, MeetingTypeDTOs.PutRequest>
