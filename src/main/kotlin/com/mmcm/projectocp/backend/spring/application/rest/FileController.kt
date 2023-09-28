package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.FileDTOs
import com.mmcm.projectocp.backend.spring.domain.service.FileService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/files")
class FileController(
    private val fileService: FileService
): EntityController<FileDTOs.GetResult, FileDTOs.PostRequest, FileDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<FileDTOs.GetResult>> {
        return try {
            val files = fileService.getEntities(pageable)
            ResponseEntity.ok(files)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<FileDTOs.GetResult>> {
        return try {
            val file = fileService.getEntityById(id, pageable)
            ResponseEntity.ok(file)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<FileDTOs.GetResult>> {
        return try {
            val file = fileService.deleteEntityById(id, pageable)
            ResponseEntity.ok(file)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: FileDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<FileDTOs.GetResult>> {
        return try {
            val file = fileService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(file)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: FileDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<FileDTOs.GetResult>> {
        return try {
            val file = fileService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(file)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}