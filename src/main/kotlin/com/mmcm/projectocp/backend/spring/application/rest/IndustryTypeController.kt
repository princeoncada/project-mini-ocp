package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.IndustryTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.IndustryTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/industry-types")
class IndustryTypeController(
    private val industryTypeService: IndustryTypeService
): EntityController<IndustryTypeDTOs.GetResult, IndustryTypeDTOs.PostRequest, IndustryTypeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<IndustryTypeDTOs.GetResult>> {
        return try {
            val department = industryTypeService.getEntities(pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<IndustryTypeDTOs.GetResult>> {
        return try {
            val department = industryTypeService.getEntityById(id, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: IndustryTypeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<IndustryTypeDTOs.GetResult>> {
        return try {
            val department = industryTypeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: IndustryTypeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<IndustryTypeDTOs.GetResult>> {
        return try {
            val department = industryTypeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<IndustryTypeDTOs.GetResult>> {
        return try {
            val department = industryTypeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}