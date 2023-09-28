package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.RefreshToken
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface RefreshTokenRepository: JpaRepository<RefreshToken, String> {
    fun findById(id: String, pageable: Pageable): Page<RefreshToken>
    fun findByUserId(userId: String): Optional<RefreshToken>
}