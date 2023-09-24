package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyCategoryDTOs
import org.springframework.stereotype.Service

@Service
interface CompanyCategoryService : EntityService<CompanyCategoryDTOs.GetResult, CompanyCategoryDTOs.PostRequest, CompanyCategoryDTOs.PutRequest>{
}