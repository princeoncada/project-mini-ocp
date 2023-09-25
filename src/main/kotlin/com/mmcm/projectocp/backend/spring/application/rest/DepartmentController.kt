package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTOs
import com.mmcm.projectocp.backend.spring.domain.service.DepartmentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/departments")
class DepartmentController(
    private val departmentService: DepartmentService
): EntityController<DepartmentDTOs.GetResult, DepartmentDTOs.PostRequest, DepartmentDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<DepartmentDTOs.GetResult>> {
        return try {
            val department = departmentService.getEntities(pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<DepartmentDTOs.GetResult>> {
        return try {
            val department = departmentService.getEntityById(id, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping()
    override fun createEntity(
        @RequestBody entityRequest: DepartmentDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<DepartmentDTOs.GetResult>> {
        return try {
            val department = departmentService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }


    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: DepartmentDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<DepartmentDTOs.GetResult>> {
        return try {
            val department = departmentService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<DepartmentDTOs.GetResult>> {
        return try {
            val department = departmentService.deleteEntityById(id, pageable)
            ResponseEntity.ok(department)
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}