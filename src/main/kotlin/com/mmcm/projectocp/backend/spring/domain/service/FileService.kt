package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.FileDTOs
import org.springframework.stereotype.Service

@Service
interface FileService: EntityService<FileDTOs.GetResult, FileDTOs.PostRequest, FileDTOs.PutRequest> {
}