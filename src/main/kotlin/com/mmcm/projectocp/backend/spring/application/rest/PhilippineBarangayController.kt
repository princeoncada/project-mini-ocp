package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineBarangayDTOs
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineBarangayService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/philippine-barangay")
class PhilippineBarangayController(
    private val philippineBarangayService: PhilippineBarangayService,
): EntityController<PhilippineBarangayDTOs.GetResult, PhilippineBarangayDTOs.PostRequest, PhilippineBarangayDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineBarangayDTOs.GetResult>> {
        return try {
            val entities = philippineBarangayService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineBarangayDTOs.GetResult>> {
        return try {
            val entity = philippineBarangayService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: PhilippineBarangayDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineBarangayDTOs.GetResult>> {
        return try {
            val entity = philippineBarangayService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: PhilippineBarangayDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineBarangayDTOs.GetResult>> {
        return try {
            val entity = philippineBarangayService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineBarangayDTOs.GetResult>> {
        return try {
            val entity = philippineBarangayService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}