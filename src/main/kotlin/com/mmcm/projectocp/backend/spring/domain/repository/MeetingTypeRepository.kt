package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.MeetingType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MeetingTypeRepository: JpaRepository<MeetingType, String> {
    fun findById(id: String, pageable: Pageable): Page<MeetingType>
    fun findByName(name: String): Optional<MeetingType>
}
