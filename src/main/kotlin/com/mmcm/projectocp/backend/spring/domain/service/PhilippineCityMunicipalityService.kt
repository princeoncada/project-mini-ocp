package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineCityMunicipalityDTOs
import org.springframework.stereotype.Service

@Service
interface PhilippineCityMunicipalityService: EntityService<PhilippineCityMunicipalityDTOs.GetResult, PhilippineCityMunicipalityDTOs.PostRequest, PhilippineCityMunicipalityDTOs.PutRequest> {
}