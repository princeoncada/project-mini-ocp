package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserEmailDTOs
import com.mmcm.projectocp.backend.spring.domain.service.UserEmailService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user-emails")
class UserEmailController(
    private val userEmailService: UserEmailService
): EntityController<UserEmailDTOs.GetResult, UserEmailDTOs.PostRequest, UserEmailDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<UserEmailDTOs.GetResult>> {
        return try {
            val entities = userEmailService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<UserEmailDTOs.GetResult>> {
        return try {
            val entities = userEmailService.getEntityById(id, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<UserEmailDTOs.GetResult>> {
        return try {
            val entities = userEmailService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: UserEmailDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<UserEmailDTOs.GetResult>> {
        return try {
            val entities = userEmailService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: UserEmailDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<UserEmailDTOs.GetResult>> {
        return try {
            val entities = userEmailService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}