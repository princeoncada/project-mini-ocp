package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.LinkType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface LinkTypeRepository: JpaRepository<LinkType, String> {
    fun findById(id: String, pageable:Pageable): Page<LinkType>
    fun findByType(type: String): Optional<LinkType>
}
