package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.FileTypeDTOs
import org.springframework.stereotype.Service

@Service
interface FileTypeService: EntityService<FileTypeDTOs.GetResult, FileTypeDTOs.PostRequest, FileTypeDTOs.PutRequest> {
}