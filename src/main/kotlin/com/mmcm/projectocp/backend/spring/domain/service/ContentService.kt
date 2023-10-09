package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.ContentDTOs
import org.springframework.stereotype.Service

@Service
interface ContentService: EntityService<ContentDTOs.GetResult, ContentDTOs.PostRequest, ContentDTOs.PutRequest> {
}