package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.LinkTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.LinkTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/link-types")
class LinkTypeController(
    private val linkTypeService: LinkTypeService
): EntityController<LinkTypeDTOs.GetResult, LinkTypeDTOs.PostRequest, LinkTypeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<LinkTypeDTOs.GetResult>> {
        return try {
            val linkTypes = linkTypeService.getEntities(pageable)
            ResponseEntity.ok(linkTypes)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<LinkTypeDTOs.GetResult>> {
        return try {
            val linkType = linkTypeService.getEntityById(id, pageable)
            ResponseEntity.ok(linkType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<LinkTypeDTOs.GetResult>> {
        return try {
            val linkType = linkTypeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(linkType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: LinkTypeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<LinkTypeDTOs.GetResult>> {
        return try {
            val linkType = linkTypeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(linkType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: LinkTypeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<LinkTypeDTOs.GetResult>> {
        return try {
            val linkType = linkTypeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(linkType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}