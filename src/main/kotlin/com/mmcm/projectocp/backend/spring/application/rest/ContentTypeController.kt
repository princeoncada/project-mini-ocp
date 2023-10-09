package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.ContentTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.ContentTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/content-types")
class ContentTypeController(
    private val contentTypeService: ContentTypeService
): EntityController<ContentTypeDTOs.GetResult, ContentTypeDTOs.PostRequest, ContentTypeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<ContentTypeDTOs.GetResult>> {
        return try {
            val contentTypes = contentTypeService.getEntities(pageable)
            ResponseEntity.ok(contentTypes)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<ContentTypeDTOs.GetResult>> {
        return try {
            val contentType = contentTypeService.getEntityById(id, pageable)
            ResponseEntity.ok(contentType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<ContentTypeDTOs.GetResult>> {
        return try {
            val contentType = contentTypeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(contentType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: ContentTypeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<ContentTypeDTOs.GetResult>> {
        return try {
            val contentType = contentTypeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(contentType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: ContentTypeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<ContentTypeDTOs.GetResult>> {
        return try {
            val contentType = contentTypeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(contentType)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}