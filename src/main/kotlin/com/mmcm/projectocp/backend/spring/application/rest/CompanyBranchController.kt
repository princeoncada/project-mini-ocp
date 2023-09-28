package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.CompanyBranchDTOs
import com.mmcm.projectocp.backend.spring.domain.service.CompanyBranchService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/company-branches")
class CompanyBranchController(
    private val companyBranchService: CompanyBranchService
): EntityController<CompanyBranchDTOs.GetResult, CompanyBranchDTOs.PostRequest, CompanyBranchDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<CompanyBranchDTOs.GetResult>> {
        return try {
            val companyBranches = companyBranchService.getEntities(pageable)
            ResponseEntity.ok(companyBranches)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyBranchDTOs.GetResult>> {
        return try {
            val companyBranches = companyBranchService.getEntityById(id, pageable)
            ResponseEntity.ok(companyBranches)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyBranchDTOs.GetResult>> {
        return try {
            val companyBranches = companyBranchService.deleteEntityById(id, pageable)
            ResponseEntity.ok(companyBranches)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: CompanyBranchDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyBranchDTOs.GetResult>> {
        return try {
            val companyBranches = companyBranchService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(companyBranches)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: CompanyBranchDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CompanyBranchDTOs.GetResult>> {
        return try {
            val companyBranches = companyBranchService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(companyBranches)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}