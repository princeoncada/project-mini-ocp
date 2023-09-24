package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYearDTOs
import org.springframework.stereotype.Service

@Service
interface AcademicYearService : EntityService<AcademicYearDTOs.GetResult,AcademicYearDTOs.PostRequest, AcademicYearDTOs.PutRequest>{


}