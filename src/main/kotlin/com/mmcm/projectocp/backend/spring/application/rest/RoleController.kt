package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.RoleDTOs
import com.mmcm.projectocp.backend.spring.domain.service.RoleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/roles")
class RoleController(
    private val roleService: RoleService
): Controller<RoleDTOs.GetResult, RoleDTOs.PostRequest, RoleDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<RoleDTOs.GetResult>> {
        return try {
            val role = roleService.getEntities(pageable)
            ResponseEntity.ok(role)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<RoleDTOs.GetResult>> {
        return try {
            val role = roleService.getEntityById(id, pageable)
            ResponseEntity.ok(role)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<RoleDTOs.GetResult>> {
        return try {
            val role = roleService.deleteEntityById(id, pageable)
            ResponseEntity.ok(role)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: RoleDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<RoleDTOs.GetResult>> {
        return try {
            val role = roleService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(role)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: RoleDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<RoleDTOs.GetResult>> {
        return try {
            val role = roleService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(role)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

}
