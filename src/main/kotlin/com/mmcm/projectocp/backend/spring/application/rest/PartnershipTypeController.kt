package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.PartnershipTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.PartnershipTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/partnership-types")
class PartnershipTypeController(
    private val partnershipTypeService: PartnershipTypeService
): EntityController<PartnershipTypeDTOs.GetResult, PartnershipTypeDTOs.PostRequest, PartnershipTypeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<PartnershipTypeDTOs.GetResult>> {
        return try {
            val partnershipType = partnershipTypeService.getEntities(pageable)
            ResponseEntity.ok(partnershipType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PartnershipTypeDTOs.GetResult>> {
        return try {
            val partnershipType = partnershipTypeService.getEntityById(id, pageable)
            ResponseEntity.ok(partnershipType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: PartnershipTypeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PartnershipTypeDTOs.GetResult>> {
        return try {
            val partnershipType = partnershipTypeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(partnershipType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: PartnershipTypeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PartnershipTypeDTOs.GetResult>> {
        return try {
            val partnershipType = partnershipTypeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(partnershipType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PartnershipTypeDTOs.GetResult>> {
        return try {
            val partnershipType = partnershipTypeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(partnershipType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}