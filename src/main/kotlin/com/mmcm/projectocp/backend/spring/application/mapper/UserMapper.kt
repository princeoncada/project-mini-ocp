package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.UserDTO
import com.mmcm.projectocp.backend.spring.domain.model.User
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class UserMapper(
    private val userRepository: UserRepository,
    private val userRoleRepository: UserRoleRepository
) {
    fun toUserDTO(user: User): UserDTO {
        return UserDTO(
            id = user.id,
            email = user.email,
            firstName = user.firstName,
            lastName = user.lastName,
            studentId = user.studentId,
            designation = user.designation,
        )
    }

    fun toUserEntity(userDTO: UserDTO): User {
        return User(
            id = userDTO.id,
            email = userDTO.email,
            firstName = userDTO.firstName,
            lastName = userDTO.lastName,
            studentId = userDTO.studentId,
            designation = userDTO.designation,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        )
    }
}