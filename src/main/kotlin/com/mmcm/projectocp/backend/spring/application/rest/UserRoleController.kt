package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserRoleDTOs
import com.mmcm.projectocp.backend.spring.domain.service.UserRoleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user-roles")
class UserRoleController(
    private val userRoleService: UserRoleService
) : EntityController<UserRoleDTOs.GetResult, UserRoleDTOs.PostRequest, UserRoleDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<UserRoleDTOs.GetResult>> {
        return try {
            val userRole = userRoleService.getEntities(pageable)
            ResponseEntity.ok(userRole)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String, pageable: Pageable
    ): ResponseEntity<Page<UserRoleDTOs.GetResult>> {
        return try {
            val userRole = userRoleService.getEntityById(id, pageable)
            ResponseEntity.ok(userRole)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: UserRoleDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<UserRoleDTOs.GetResult>> {
        return try {
            val userRole = userRoleService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(userRole)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }


    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: UserRoleDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<UserRoleDTOs.GetResult>> {
        return try {
            val userRole = userRoleService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(userRole)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String, pageable: Pageable
    ): ResponseEntity<Page<UserRoleDTOs.GetResult>> {
        return try {
            val userRole = userRoleService.deleteEntityById(id, pageable)
            ResponseEntity.ok(userRole)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }


}