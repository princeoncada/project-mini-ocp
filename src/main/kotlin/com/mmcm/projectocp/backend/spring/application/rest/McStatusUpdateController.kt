package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.McStatusUpdateDTOs
import com.mmcm.projectocp.backend.spring.domain.service.McStatusUpdateService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/mc-status-updates")
class McStatusUpdateController(
    private val mcStatusUpdateService: McStatusUpdateService
): EntityController<McStatusUpdateDTOs.GetResult, McStatusUpdateDTOs.PostRequest, McStatusUpdateDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<McStatusUpdateDTOs.GetResult>> {
        return try {
            val entities = mcStatusUpdateService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusUpdateDTOs.GetResult>> {
        return try {
            val entity = mcStatusUpdateService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusUpdateDTOs.GetResult>> {
        return try {
            val entity = mcStatusUpdateService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: McStatusUpdateDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusUpdateDTOs.GetResult>> {
        return try {
            val entity = mcStatusUpdateService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: McStatusUpdateDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<McStatusUpdateDTOs.GetResult>> {
        return try {
            val entity = mcStatusUpdateService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}