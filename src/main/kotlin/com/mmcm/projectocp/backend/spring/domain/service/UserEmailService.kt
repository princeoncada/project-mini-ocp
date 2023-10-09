package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserEmailDTOs
import org.springframework.stereotype.Service

@Service
interface UserEmailService: EntityService<UserEmailDTOs.GetResult, UserEmailDTOs.PostRequest, UserEmailDTOs.PutRequest> {
}