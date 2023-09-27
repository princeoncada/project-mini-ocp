package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyDTOs
import org.springframework.stereotype.Service

@Service
interface CompanyService: EntityService<CompanyDTOs.GetResult, CompanyDTOs.PostRequest, CompanyDTOs.PutRequest> {
}