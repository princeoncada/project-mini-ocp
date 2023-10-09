package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.RequirementDTOs
import com.mmcm.projectocp.backend.spring.domain.service.RequirementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/requirements")
class RequirementController(
    private val requirementService: RequirementService
): EntityController<RequirementDTOs.GetResult, RequirementDTOs.PostRequest, RequirementDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<RequirementDTOs.GetResult>> {
        return try {
            val requirements = requirementService.getEntities(pageable)
            ResponseEntity.ok(requirements)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementDTOs.GetResult>> {
        return try {
            val requirement = requirementService.getEntityById(id, pageable)
            ResponseEntity.ok(requirement)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementDTOs.GetResult>> {
        return try {
            val requirement = requirementService.deleteEntityById(id, pageable)
            ResponseEntity.ok(requirement)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: RequirementDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementDTOs.GetResult>> {
        return try {
            val requirement = requirementService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(requirement)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: RequirementDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementDTOs.GetResult>> {
        return try {
            val requirement = requirementService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(requirement)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}