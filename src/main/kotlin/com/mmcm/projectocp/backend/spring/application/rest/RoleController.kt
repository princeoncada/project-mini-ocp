package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.domain.model.Role
import com.mmcm.projectocp.backend.spring.domain.repository.RoleRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/roles")
class RoleController(
    private val roleRepository: RoleRepository,
) {

    @GetMapping
    fun getRoles(pageable: Pageable): Page<Role> {
        return roleRepository.findAll(pageable)
    }

}
