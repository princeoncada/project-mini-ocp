package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineRegionDTOs
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineRegionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/philippine-regions")
class PhilippineRegionController(
    private val philippineRegionService: PhilippineRegionService
): EntityController<PhilippineRegionDTOs.GetResult, PhilippineRegionDTOs.PostRequest, PhilippineRegionDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineRegionDTOs.GetResult>> {
        return try {
            val entities = philippineRegionService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineRegionDTOs.GetResult>> {
        return try {
            val entity = philippineRegionService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: PhilippineRegionDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineRegionDTOs.GetResult>> {
        return try {
            val entity = philippineRegionService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: PhilippineRegionDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineRegionDTOs.GetResult>> {
        return try {
            val entity = philippineRegionService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineRegionDTOs.GetResult>> {
        return try {
            val entity = philippineRegionService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}