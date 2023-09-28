package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.RefreshTokenDTOs
import com.mmcm.projectocp.backend.spring.domain.model.RefreshToken
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDateTime

@Component
class RefreshTokenMapper(
    private val userRepository: UserRepository
) {
    fun toGetResult(
        entity: RefreshToken
    ): RefreshTokenDTOs.GetResult {
        return RefreshTokenDTOs.GetResult(
            id = entity.id,
            user = entity.user.email,
            refreshToken = entity.refreshToken,
            expirationDate = entity.expirationDate.toString()
        )
    }

    fun createEntity(
        id: String,
        entityRequest: RefreshTokenDTOs.PostRequest
    ): RefreshToken {
        return RefreshToken(
            id = id,
            user = userRepository.findById(entityRequest.userId).get(),
            refreshToken = entityRequest.refreshToken,
            expirationDate = LocalDateTime.parse(entityRequest.expirationDate),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }
}