package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserDTOs
import org.springframework.stereotype.Service

@Service
interface UserService: EntityService<UserDTOs.GetResult, UserDTOs.PostRequest, UserDTOs.PutRequest> {
}