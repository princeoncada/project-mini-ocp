package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserDTOs
import com.mmcm.projectocp.backend.spring.domain.model.User
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class UserMapper: EntityMapper<User, UserDTOs.GetResult, UserDTOs.PostRequest, UserDTOs.PutRequest> {
    override fun toGetResult(entity: User): UserDTOs.GetResult {
        return UserDTOs.GetResult(
            id = entity.id,
            email = entity.email,
            firstName = entity.firstName,
            lastName = entity.lastName,
            studentId = entity.studentId,
            designation = entity.designation
        )
    }

    override fun createEntity(id: String, entityRequest: UserDTOs.PostRequest): User {
        return User(
            id = id,
            email = entityRequest.email,
            firstName = entityRequest.firstName,
            lastName = entityRequest.lastName,
            studentId = entityRequest.studentId,
            designation = entityRequest.designation,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }

    override fun updateEntity(entity: User, entityRequest: UserDTOs.PutRequest): User {
        return User(
            id = entity.id,
            email = entityRequest.email ?: entity.email,
            firstName = entityRequest.firstName ?: entity.firstName,
            lastName = entityRequest.lastName ?: entity.lastName,
            studentId = entityRequest.studentId ?: entity.studentId,
            designation = entityRequest.designation ?: entity.designation,
            createdAt = entity.createdAt,
            updatedAt = Instant.now()
        )
    }
}