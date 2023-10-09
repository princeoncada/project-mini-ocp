package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.ContentType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ContentTypeRepository: JpaRepository<ContentType, String> {
    fun findById(id: String, pageable: Pageable): Page<ContentType>
    fun findByType(type: String?): Optional<ContentType>
}
