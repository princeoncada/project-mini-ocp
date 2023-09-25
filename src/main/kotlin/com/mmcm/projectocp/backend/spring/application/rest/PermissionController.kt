package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.PermissionDTOs
import com.mmcm.projectocp.backend.spring.domain.service.PermissionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/permissions")
class PermissionController(
    private val permissionService: PermissionService
): EntityController<PermissionDTOs.GetResult, PermissionDTOs.PostRequest, PermissionDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<PermissionDTOs.GetResult>> {
        return try {
            val permissions = permissionService.getEntities(pageable)
            ResponseEntity.ok(permissions)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable,
    ): ResponseEntity<Page<PermissionDTOs.GetResult>> {
        return try {
            val permission = permissionService.getEntityById(id, pageable)
            ResponseEntity.ok(permission)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: PermissionDTOs.PostRequest,
        pageable: Pageable,
    ): ResponseEntity<Page<PermissionDTOs.GetResult>> {
        return try {
            val permission = permissionService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(permission)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: PermissionDTOs.PutRequest,
        pageable: Pageable,
    ): ResponseEntity<Page<PermissionDTOs.GetResult>> {
        return try {
            val permission = permissionService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(permission)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable,
    ): ResponseEntity<Page<PermissionDTOs.GetResult>> {
        return try {
            val permission = permissionService.deleteEntityById(id, pageable)
            ResponseEntity.ok(permission)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}