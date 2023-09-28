package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CompanyContactPersonDTOs
import org.springframework.stereotype.Service

@Service
interface CompanyContactPersonService: EntityService<CompanyContactPersonDTOs.GetResult, CompanyContactPersonDTOs.PostRequest, CompanyContactPersonDTOs.PutRequest> {
}