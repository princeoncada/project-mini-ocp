package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.RequirementSubmissionDTOs
import com.mmcm.projectocp.backend.spring.domain.service.RequirementSubmissionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/requirement-submissions")
class RequirementSubmissionController(
    private val requirementSubmissionService: RequirementSubmissionService
): EntityController<RequirementSubmissionDTOs.GetResult, RequirementSubmissionDTOs.PostRequest, RequirementSubmissionDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<RequirementSubmissionDTOs.GetResult>> {
        return try {
            val entities = requirementSubmissionService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementSubmissionDTOs.GetResult>> {
        return try {
            val entities = requirementSubmissionService.getEntityById(id, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementSubmissionDTOs.GetResult>> {
        return try {
            val entities = requirementSubmissionService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: RequirementSubmissionDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementSubmissionDTOs.GetResult>> {
        return try {
            val entities = requirementSubmissionService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: RequirementSubmissionDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<RequirementSubmissionDTOs.GetResult>> {
        return try {
            val entities = requirementSubmissionService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}