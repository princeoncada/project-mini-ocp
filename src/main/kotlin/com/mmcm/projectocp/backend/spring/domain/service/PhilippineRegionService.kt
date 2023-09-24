package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineRegionDTOs
import org.springframework.stereotype.Service

@Service
interface PhilippineRegionService : EntityService<PhilippineRegionDTOs.GetResult, PhilippineRegionDTOs.PostRequest, PhilippineRegionDTOs.PutRequest>{
}