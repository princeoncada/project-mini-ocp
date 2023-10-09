package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.TermDTOs
import com.mmcm.projectocp.backend.spring.domain.service.TermService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/terms")
class TermController(
    private val termService: TermService
): EntityController<TermDTOs.GetResult, TermDTOs.PostRequest, TermDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<TermDTOs.GetResult>> {
        return try {
            val terms = termService.getEntities(pageable)
            ResponseEntity.ok(terms)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<TermDTOs.GetResult>> {
        return try {
            val term = termService.getEntityById(id, pageable)
            ResponseEntity.ok(term)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<TermDTOs.GetResult>> {
        return try {
            val term = termService.deleteEntityById(id, pageable)
            ResponseEntity.ok(term)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: TermDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<TermDTOs.GetResult>> {
        return try {
            val term = termService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(term)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: TermDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<TermDTOs.GetResult>> {
        return try {
            val term = termService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(term)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}