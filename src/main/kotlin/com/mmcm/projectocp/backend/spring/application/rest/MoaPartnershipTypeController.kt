package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.MoaPartnershipTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.MoaPartnershipTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/moa-partnership-types")
class MoaPartnershipTypeController(
    private val moaPartnershipTypeService: MoaPartnershipTypeService
): EntityController<MoaPartnershipTypeDTOs.GetResult, MoaPartnershipTypeDTOs.PostRequest, MoaPartnershipTypeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<MoaPartnershipTypeDTOs.GetResult>> {
        return try {
            val entities = moaPartnershipTypeService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPartnershipTypeDTOs.GetResult>> {
        return try {
            val entity = moaPartnershipTypeService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPartnershipTypeDTOs.GetResult>> {
        return try {
            val entity = moaPartnershipTypeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: MoaPartnershipTypeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPartnershipTypeDTOs.GetResult>> {
        return try {
            val entity = moaPartnershipTypeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: MoaPartnershipTypeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPartnershipTypeDTOs.GetResult>> {
        return try {
            val entity = moaPartnershipTypeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}