package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MeetingType
import org.springframework.data.jpa.repository.JpaRepository

interface MeetingTypeRepository : JpaRepository<MeetingType, String> {
    // You can add custom query methods here if needed
}
