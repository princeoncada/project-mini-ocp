package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.CountryDTOs
import org.springframework.stereotype.Service

@Service
interface CountryService : EntityService<CountryDTOs.GetResult, CountryDTOs.PostRequest,CountryDTOs.PutRequest>
