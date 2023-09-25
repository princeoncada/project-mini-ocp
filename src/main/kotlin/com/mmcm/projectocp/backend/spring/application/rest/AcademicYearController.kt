package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYearDTOs
import com.mmcm.projectocp.backend.spring.domain.service.AcademicYearService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/academic-years")
class AcademicYearController(
    private val academicYearService: AcademicYearService
): EntityController<AcademicYearDTOs.GetResult, AcademicYearDTOs.PostRequest, AcademicYearDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<AcademicYearDTOs.GetResult>> {
        return try {
            val academicYears = academicYearService.getEntities(pageable)
            ResponseEntity.ok(academicYears)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<AcademicYearDTOs.GetResult>> {
        return try {
            val academicYear = academicYearService.getEntityById(id, pageable)
            ResponseEntity.ok(academicYear)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: AcademicYearDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<AcademicYearDTOs.GetResult>> {
        return try {
            val academicYear = academicYearService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(academicYear)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: AcademicYearDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<AcademicYearDTOs.GetResult>> {
        return try {
            val academicYear = academicYearService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(academicYear)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<AcademicYearDTOs.GetResult>> {
        return try {
            val academicYear = academicYearService.deleteEntityById(id, pageable)
            ResponseEntity.ok(academicYear)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}