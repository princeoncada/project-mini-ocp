package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyBranchDTOs
import org.springframework.stereotype.Service

@Service
interface CompanyBranchService: EntityService<CompanyBranchDTOs.GetResult, CompanyBranchDTOs.PostRequest, CompanyBranchDTOs.PutRequest> {
}