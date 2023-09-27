package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineProvinceDTOs
import org.springframework.stereotype.Service

@Service
interface PhilippineProvinceService: EntityService<PhilippineProvinceDTOs.GetResult, PhilippineProvinceDTOs.PostRequest, PhilippineProvinceDTOs.PutRequest> {
}