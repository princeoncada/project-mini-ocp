package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionDTOs
import com.mmcm.projectocp.backend.spring.domain.service.MoaPositionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/moa-positions")
class MoaPositionController(
    private val moaPositionService: MoaPositionService
): EntityController<MoaPositionDTOs.GetResult, MoaPositionDTOs.PostRequest, MoaPositionDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionDTOs.GetResult>> {
        return try {
            val entities = moaPositionService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionDTOs.GetResult>> {
        return try {
            val entity = moaPositionService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionDTOs.GetResult>> {
        return try {
            val entity = moaPositionService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: MoaPositionDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionDTOs.GetResult>> {
        return try {
            val entity = moaPositionService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: MoaPositionDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionDTOs.GetResult>> {
        return try {
            val entity = moaPositionService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}