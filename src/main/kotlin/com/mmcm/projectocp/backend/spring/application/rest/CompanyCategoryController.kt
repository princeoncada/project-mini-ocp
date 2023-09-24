package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.CompanyCategoryDTOs
import com.mmcm.projectocp.backend.spring.domain.service.CompanyCategoryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company-categories")
class CompanyCategoryController(
    private val companyCategoryService: CompanyCategoryService
) : EntityController<CompanyCategoryDTOs.GetResult, CompanyCategoryDTOs.PostRequest, CompanyCategoryDTOs.PutRequest> {

    @GetMapping
    override fun getEntities(pageable: Pageable): ResponseEntity<Page<CompanyCategoryDTOs.GetResult>> {
        return try {
            val companyCategory = companyCategoryService.getEntities(pageable)
            ResponseEntity.ok(companyCategory)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyCategoryDTOs.GetResult>> {
        return try {
            val companyCategory = companyCategoryService.getEntityById(id, pageable)
            ResponseEntity.ok(companyCategory)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: CompanyCategoryDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyCategoryDTOs.GetResult>> {
        return try {
            val companyCategory = companyCategoryService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(companyCategory)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }


    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: CompanyCategoryDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyCategoryDTOs.GetResult>> {
        return try {
            val companyCategory = companyCategoryService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(companyCategory)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }


    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyCategoryDTOs.GetResult>> {
        return try {
            val companyCategory = companyCategoryService.deleteEntityById(id, pageable)
            ResponseEntity.ok(companyCategory)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

}