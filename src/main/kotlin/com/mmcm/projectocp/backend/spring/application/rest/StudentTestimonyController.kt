package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.StudentTestimonyDTOs
import com.mmcm.projectocp.backend.spring.domain.service.StudentTestimonyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/student-testimonies")
class StudentTestimonyController(
    private val studentTestimonyService: StudentTestimonyService
): EntityController<StudentTestimonyDTOs.GetResult, StudentTestimonyDTOs.PostRequest, StudentTestimonyDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<StudentTestimonyDTOs.GetResult>> {
        return try {
            val studentTestimonies = studentTestimonyService.getEntities(pageable)
            ResponseEntity.ok(studentTestimonies)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<StudentTestimonyDTOs.GetResult>> {
        return try {
            val studentTestimonies = studentTestimonyService.getEntityById(id, pageable)
            ResponseEntity.ok(studentTestimonies)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<StudentTestimonyDTOs.GetResult>> {
        return try {
            val studentTestimonies = studentTestimonyService.deleteEntityById(id, pageable)
            ResponseEntity.ok(studentTestimonies)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: StudentTestimonyDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<StudentTestimonyDTOs.GetResult>> {
        return try {
            val studentTestimonies = studentTestimonyService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(studentTestimonies)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: StudentTestimonyDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<StudentTestimonyDTOs.GetResult>> {
        return try {
            val studentTestimonies = studentTestimonyService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(studentTestimonies)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}