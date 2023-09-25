package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MOAOJTDeliveryMode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MOAOJTDeliveryModeRepository: JpaRepository<MOAOJTDeliveryMode, String> {
}
