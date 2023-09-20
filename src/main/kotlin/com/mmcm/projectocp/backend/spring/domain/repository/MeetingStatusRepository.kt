package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MeetingStatus
import org.springframework.data.jpa.repository.JpaRepository

interface MeetingStatusRepository : JpaRepository<MeetingStatus, String> {
    // You can add custom query methods here if needed
}
