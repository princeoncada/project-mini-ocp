package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.ContentDTOs
import com.mmcm.projectocp.backend.spring.domain.service.ContentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/contents")
class ContentController(
    private val contentService: ContentService
): EntityController<ContentDTOs.GetResult, ContentDTOs.PostRequest, ContentDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<ContentDTOs.GetResult>> {
        return try {
            val contents = contentService.getEntities(pageable)
            ResponseEntity.ok(contents)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<ContentDTOs.GetResult>> {
        return try {
            val content = contentService.getEntityById(id, pageable)
            ResponseEntity.ok(content)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<ContentDTOs.GetResult>> {
        return try {
            val content = contentService.deleteEntityById(id, pageable)
            ResponseEntity.ok(content)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: ContentDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<ContentDTOs.GetResult>> {
        return try {
            val content = contentService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(content)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: ContentDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<ContentDTOs.GetResult>> {
        return try {
            val content = contentService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(content)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}