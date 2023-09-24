package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserDTOs
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
): Controller<UserDTOs.GetResult, UserDTOs.PostRequest, UserDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<UserDTOs.GetResult>> {
        return try {
            val user = userService.getEntities(pageable)
            ResponseEntity.ok(user)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable,
    ): ResponseEntity<Page<UserDTOs.GetResult>> {
        return try {
            val user = userService.getEntityById(id, pageable)
            ResponseEntity.ok(user)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable,
    ): ResponseEntity<Page<UserDTOs.GetResult>> {
        return try {
            val user = userService.deleteEntityById(id, pageable)
            ResponseEntity.ok(user)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: UserDTOs.PutRequest,
        pageable: Pageable,
    ): ResponseEntity<Page<UserDTOs.GetResult>> {
        return try {
            val user = userService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(user)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: UserDTOs.PostRequest,
        pageable: Pageable,
    ): ResponseEntity<Page<UserDTOs.GetResult>> {
        return try {
            val user = userService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(user)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}


