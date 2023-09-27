package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserPermissionDTOs
import com.mmcm.projectocp.backend.spring.domain.service.UserPermissionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user-permissions")
class UserPermissionController(
    private val userPermissionService: UserPermissionService
) {
    @GetMapping
    fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<UserPermissionDTOs.GetResult>> {
        return try {
            val userPermission = userPermissionService.getEntities(pageable)
            ResponseEntity.ok(userPermission)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{user}/{permission}")
    fun getEntityByKey(
        @PathVariable user: String,
        @PathVariable permission: String,
        pageable: Pageable
    ): ResponseEntity<Page<UserPermissionDTOs.GetResult>> {
        return try {
            val userPermission = userPermissionService.getEntityByKey(user, permission, pageable)
            ResponseEntity.ok(userPermission)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createEntity(
        @RequestBody entityRequest: UserPermissionDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<UserPermissionDTOs.GetResult>> {
        return try {
            val userPermission = userPermissionService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(userPermission)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{user}/{permission}")
    fun updateEntityById(
        @PathVariable user: String,
        @PathVariable permission: String,
        @RequestBody entityRequest: UserPermissionDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<UserPermissionDTOs.GetResult>> {
        return try {
            val userPermission = userPermissionService.updateEntityByKey(user, permission, entityRequest, pageable)
            ResponseEntity.ok(userPermission)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{user}/{permission}")
    fun deleteEntityByKey(
        @PathVariable user: String,
        @PathVariable permission: String,
        pageable: Pageable
    ): ResponseEntity<Page<UserPermissionDTOs.GetResult>> {
        return try {
            val userPermission = userPermissionService.deleteEntityByKey(user, permission, pageable)
            ResponseEntity.ok(userPermission)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}