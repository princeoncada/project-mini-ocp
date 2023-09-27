package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineBarangayDTOs
import org.springframework.stereotype.Service

@Service
interface PhilippineBarangayService: EntityService<PhilippineBarangayDTOs.GetResult, PhilippineBarangayDTOs.PostRequest, PhilippineBarangayDTOs.PutRequest> {
}