package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.IndustryTypeDTOs
import org.springframework.stereotype.Service

@Service
interface IndustryTypeService : EntityService<IndustryTypeDTOs.GetResult, IndustryTypeDTOs.PostRequest, IndustryTypeDTOs.PutRequest>
