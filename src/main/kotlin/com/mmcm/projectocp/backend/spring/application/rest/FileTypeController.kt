package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.FileTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.FileTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/file-types")
class FileTypeController(
    private val fileTypeService: FileTypeService
): EntityController<FileTypeDTOs.GetResult, FileTypeDTOs.PostRequest, FileTypeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<FileTypeDTOs.GetResult>> {
        return try {
            val department = fileTypeService.getEntities(pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<FileTypeDTOs.GetResult>> {
        return try {
            val department = fileTypeService.getEntityById(id, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: FileTypeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<FileTypeDTOs.GetResult>> {
        return try {
            val department = fileTypeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: FileTypeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<FileTypeDTOs.GetResult>> {
        return try {
            val department = fileTypeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<FileTypeDTOs.GetResult>> {
        return try {
            val department = fileTypeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}