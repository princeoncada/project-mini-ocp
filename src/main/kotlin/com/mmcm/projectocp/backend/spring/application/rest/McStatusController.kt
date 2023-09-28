package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.McStatusDTOs
import com.mmcm.projectocp.backend.spring.domain.service.McStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/mc-statuses")
class McStatusController(
    private val mcStatusService: McStatusService,
): EntityController<McStatusDTOs.GetResult, McStatusDTOs.PostRequest, McStatusDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<McStatusDTOs.GetResult>> {
        return try {
            val entities = mcStatusService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusDTOs.GetResult>> {
        return try {
            val entity = mcStatusService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: McStatusDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusDTOs.GetResult>> {
        return try {
            val entity = mcStatusService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: McStatusDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusDTOs.GetResult>> {
        return try {
            val entity = mcStatusService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusDTOs.GetResult>> {
        return try {
            val entity = mcStatusService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}