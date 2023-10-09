package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserEmailDTOs
import com.mmcm.projectocp.backend.spring.domain.model.UserEmail
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class UserEmailMapper(
    private val userRepository: UserRepository
): EntityMapper<UserEmail, UserEmailDTOs.GetResult, UserEmailDTOs.PostRequest, UserEmailDTOs.PutRequest> {
    override fun toGetResult(
        entity: UserEmail
    ): UserEmailDTOs.GetResult {
        return UserEmailDTOs.GetResult(
            id = entity.id,
            userId = entity.user.id,
            email = entity.email
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: UserEmailDTOs.PostRequest
    ): UserEmail {
        return UserEmail(
            id = id,
            user = userRepository.findById(entityRequest.userId).get(),
            email = entityRequest.email,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(
        entity: UserEmail,
        entityRequest: UserEmailDTOs.PutRequest
    ): UserEmail {
        return UserEmail(
            id = entity.id,
            user = userRepository.findById(entityRequest.userId ?: entity.user.id).get(),
            email = entityRequest.email ?: entity.email,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}