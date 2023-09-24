package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.SessionDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Session
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Component
class SessionMapper(
    private val userRepository: UserRepository
): EntityMapper<Session, SessionDTOs.GetResult, SessionDTOs.PostRequest, SessionDTOs.PutRequest> {
    override fun toGetResult(entity: Session): SessionDTOs.GetResult {
        return SessionDTOs.GetResult(
            id = entity.id,
            user = entity.user.email,
            expiresOn = entity.expiresOn.toString()
        )
    }

    override fun createEntity(id: String, entityRequest: SessionDTOs.PostRequest): Session {
        return Session(
            id = id,
            user = userRepository.findByEmail(entityRequest.user).getOrNull()
                ?: userRepository.findById(entityRequest.user).get(),
            expiresOn = LocalDateTime.parse(entityRequest.expiresOn),
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(entity: Session, entityRequest: SessionDTOs.PutRequest): Session {
        return Session(
            id = entity.id,
            user = userRepository.findByEmail(entityRequest.user).getOrNull()
                ?: userRepository.findById(entityRequest.user ?: entity.user.id).get(),
            expiresOn = LocalDateTime.parse(entityRequest.expiresOn ?: entity.expiresOn.toString()),
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}