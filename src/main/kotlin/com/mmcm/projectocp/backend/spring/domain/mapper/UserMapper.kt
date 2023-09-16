package com.mmcm.projectocp.backend.spring.domain.mapper

import com.mmcm.projectocp.backend.spring.domain.model.User
import com.mmcm.projectocp.backend.spring.domain.dto.UserDTO
import org.springframework.stereotype.Component

@Component
class UserMapper {
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
        val user = User()
        user.id = userDTO.id
        user.email = userDTO.email
        user.firstName = userDTO.firstName
        user.lastName = userDTO.lastName
        user.studentId = userDTO.studentId
        user.designation = userDTO.designation
        return user
    }
}