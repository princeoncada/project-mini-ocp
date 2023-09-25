package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.SessionDTOs
import com.mmcm.projectocp.backend.spring.domain.service.SessionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sessions")
class SessionController(
    private val sessionService: SessionService
): EntityController<SessionDTOs.GetResult, SessionDTOs.PostRequest, SessionDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<SessionDTOs.GetResult>> {
        return try {
            val session = sessionService.getEntities(pageable)
            ResponseEntity.ok(session)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<SessionDTOs.GetResult>> {
        return try {
            val session = sessionService.getEntityById(id, pageable)
            ResponseEntity.ok(session)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: SessionDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<SessionDTOs.GetResult>> {
        return try {
            val session = sessionService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(session)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }


    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: SessionDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<SessionDTOs.GetResult>> {
        return try {
            val session = sessionService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(session)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<SessionDTOs.GetResult>> {
        return try {
            val session = sessionService.deleteEntityById(id, pageable)
            ResponseEntity.ok(session)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}