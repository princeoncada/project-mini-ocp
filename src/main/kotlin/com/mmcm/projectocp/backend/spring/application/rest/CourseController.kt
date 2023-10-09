package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.CourseDTOs
import com.mmcm.projectocp.backend.spring.domain.service.CourseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/courses")
class CourseController(
    private val courseService: CourseService
): EntityController<CourseDTOs.GetResult, CourseDTOs.PostRequest, CourseDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<CourseDTOs.GetResult>> {
        return try {
            val courses = courseService.getEntities(pageable)
            ResponseEntity.ok(courses)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CourseDTOs.GetResult>> {
        return try {
            val course = courseService.getEntityById(id, pageable)
            ResponseEntity.ok(course)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<CourseDTOs.GetResult>> {
        return try {
            val course = courseService.deleteEntityById(id, pageable)
            ResponseEntity.ok(course)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: CourseDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CourseDTOs.GetResult>> {
        return try {
            val course = courseService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(course)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: CourseDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CourseDTOs.GetResult>> {
        return try {
            val course = courseService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(course)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}