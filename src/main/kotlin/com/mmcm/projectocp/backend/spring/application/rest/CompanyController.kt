package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.CompanyDTOs
import com.mmcm.projectocp.backend.spring.domain.service.CompanyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/companies")
class CompanyController(
    private val companyService: CompanyService
): EntityController<CompanyDTOs.GetResult, CompanyDTOs.PostRequest, CompanyDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<CompanyDTOs.GetResult>> {
        return try {
            val entities = companyService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyDTOs.GetResult>> {
        return try {
            val entity = companyService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: CompanyDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyDTOs.GetResult>> {
        return try {
            val entity = companyService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: CompanyDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyDTOs.GetResult>> {
        return try {
            val entity = companyService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyDTOs.GetResult>> {
        return try {
            val entity = companyService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}