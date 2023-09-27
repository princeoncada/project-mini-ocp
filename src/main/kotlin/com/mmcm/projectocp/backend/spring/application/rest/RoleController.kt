package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.RoleDTOs
import com.mmcm.projectocp.backend.spring.domain.service.RoleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/roles")
class RoleController(
    private val roleService: RoleService
): EntityController<RoleDTOs.GetResult, RoleDTOs.PostRequest, RoleDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<RoleDTOs.GetResult>> {
        return try {
            val role = roleService.getEntities(pageable)
            ResponseEntity.ok(role)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
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
            ResponseEntity.notFound().build()
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
            ResponseEntity.notFound().build()
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
            ResponseEntity.notFound().build()
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
            ResponseEntity.notFound().build()
        }
    }
}