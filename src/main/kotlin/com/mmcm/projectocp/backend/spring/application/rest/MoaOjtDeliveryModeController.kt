package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.MoaOjtDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.MoaOjtDeliveryModeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/moa-ojt-delivery-modes")
class MoaOjtDeliveryModeController(
    private val moaOjtDeliveryModeService: MoaOjtDeliveryModeService
): EntityController<MoaOjtDeliveryModeDTOs.GetResult, MoaOjtDeliveryModeDTOs.PostRequest, MoaOjtDeliveryModeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<MoaOjtDeliveryModeDTOs.GetResult>> {
        return try {
            val entities = moaOjtDeliveryModeService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaOjtDeliveryModeDTOs.GetResult>> {
        return try {
            val entity = moaOjtDeliveryModeService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaOjtDeliveryModeDTOs.GetResult>> {
        return try {
            val entity = moaOjtDeliveryModeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: MoaOjtDeliveryModeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaOjtDeliveryModeDTOs.GetResult>> {
        return try {
            val entity = moaOjtDeliveryModeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: MoaOjtDeliveryModeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaOjtDeliveryModeDTOs.GetResult>> {
        return try {
            val entity = moaOjtDeliveryModeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}