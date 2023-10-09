package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.ContentTypeDTOs
import org.springframework.stereotype.Service

@Service
interface ContentTypeService: EntityService<ContentTypeDTOs.GetResult, ContentTypeDTOs.PostRequest, ContentTypeDTOs.PutRequest> {
}