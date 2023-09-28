package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.CompanyContactPersonDTOs
import com.mmcm.projectocp.backend.spring.domain.service.CompanyContactPersonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company-contact-persons")
class CompanyContactPersonController(
    private val companyContactPersonService: CompanyContactPersonService
): EntityController<CompanyContactPersonDTOs.GetResult, CompanyContactPersonDTOs.PostRequest, CompanyContactPersonDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<CompanyContactPersonDTOs.GetResult>> {
        return try {
            val companyContactPersons = companyContactPersonService.getEntities(pageable)
            ResponseEntity.ok(companyContactPersons)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyContactPersonDTOs.GetResult>> {
        return try {
            val companyContactPerson = companyContactPersonService.getEntityById(id, pageable)
            ResponseEntity.ok(companyContactPerson)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: CompanyContactPersonDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyContactPersonDTOs.GetResult>> {
        return try {
            val companyContactPerson = companyContactPersonService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(companyContactPerson)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: CompanyContactPersonDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyContactPersonDTOs.GetResult>> {
        return try {
            val companyContactPerson = companyContactPersonService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(companyContactPerson)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyContactPersonDTOs.GetResult>> {
        return try {
            val companyContactPerson = companyContactPersonService.deleteEntityById(id, pageable)
            ResponseEntity.ok(companyContactPerson)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}