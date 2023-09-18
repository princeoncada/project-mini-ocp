package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTO
import com.mmcm.projectocp.backend.spring.application.mapper.UserRoleMapper
import com.mmcm.projectocp.backend.spring.domain.model.Role
import com.mmcm.projectocp.backend.spring.domain.model.User
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import com.mmcm.projectocp.backend.spring.domain.repository.RoleRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserRoleService
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.UUID

@RestController
@RequestMapping("/api/user-roles")
class UserRoleController(
    private val userRoleRepository: UserRoleRepository,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val userRoleMapper: UserRoleMapper,
    private val userRoleService: UserRoleService
) {

    data class RequestPostBody(
        var email: String,
        var role: String
    )

    @GetMapping
    fun findAll(): List<UserRoleDTO> {
        val entities = userRoleRepository.findAll()
        return entities.map { userRoleMapper.toUserRoleDTO(it) }
    }

    @GetMapping("/{email}")
    fun findByEmail(@PathVariable email: String): UserRoleDTO {
        val userRoleEntity = userRoleService.findByEmail(email)
        return userRoleMapper.toUserRoleDTO(userRoleEntity)
    }

    @PostMapping
    fun createUserRole(@RequestBody req: RequestPostBody): String {
        val user: User = userRepository.findByEmail(req.email)
        val role: Role = roleRepository.findByName(req.role)
        userRoleRepository.save(UserRole(
            id = UUID.randomUUID().toString(),
            user = user,
            role = role,
            createdAt = Instant.now(),
            updatedAt = Instant.now()
        ))
        return "Successfully Added ${user.email} as ${role.name} in tbl_user_roles"
    }
}