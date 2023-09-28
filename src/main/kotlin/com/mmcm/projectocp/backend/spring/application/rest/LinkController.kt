package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.LinkDTOs
import com.mmcm.projectocp.backend.spring.domain.service.LinkService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/links")
class LinkController(
    private val linkService: LinkService
): EntityController<LinkDTOs.GetResult, LinkDTOs.PostRequest, LinkDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<LinkDTOs.GetResult>> {
        return try {
            val links = linkService.getEntities(pageable)
            ResponseEntity.ok(links)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<LinkDTOs.GetResult>> {
        return try {
            val link = linkService.getEntityById(id, pageable)
            ResponseEntity.ok(link)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping ("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<LinkDTOs.GetResult>> {
        return try {
            val link = linkService.deleteEntityById(id, pageable)
            ResponseEntity.ok(link)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: LinkDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<LinkDTOs.GetResult>> {
        return try {
            val link = linkService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(link)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: LinkDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<LinkDTOs.GetResult>> {
        return try {
            val link = linkService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(link)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}