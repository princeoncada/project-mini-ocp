package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.OJTDeliveryModeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.OjtDeliveryModeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/ojt-delivery-modes")
class OjtDeliveryModeController (
    private val ojtDeliveryModeService: OjtDeliveryModeService
): EntityController<OJTDeliveryModeDTOs.GetResult, OJTDeliveryModeDTOs.PostRequest, OJTDeliveryModeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<OJTDeliveryModeDTOs.GetResult>> {
        return try {
            val ojtDeliveryMode = ojtDeliveryModeService.getEntities(pageable)
            ResponseEntity.ok(ojtDeliveryMode)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<OJTDeliveryModeDTOs.GetResult>> {
        return try {
            val ojtDeliveryMode = ojtDeliveryModeService.getEntityById(id, pageable)
            ResponseEntity.ok(ojtDeliveryMode)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: OJTDeliveryModeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<OJTDeliveryModeDTOs.GetResult>> {
        return try {
            val ojtDeliveryMode = ojtDeliveryModeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(ojtDeliveryMode)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: OJTDeliveryModeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<OJTDeliveryModeDTOs.GetResult>> {
        return try {
            val ojtDeliveryMode = ojtDeliveryModeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(ojtDeliveryMode)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<OJTDeliveryModeDTOs.GetResult>> {
        return try {
            val ojtDeliveryMode = ojtDeliveryModeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(ojtDeliveryMode)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}