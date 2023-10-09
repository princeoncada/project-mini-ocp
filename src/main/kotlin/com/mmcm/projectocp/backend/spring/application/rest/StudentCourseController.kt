package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.StudentCourseDTOs
import com.mmcm.projectocp.backend.spring.domain.service.StudentCourseService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/student-courses")
class StudentCourseController(
    private val studentCourseService: StudentCourseService
): EntityController<StudentCourseDTOs.GetResult, StudentCourseDTOs.PostRequest, StudentCourseDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<StudentCourseDTOs.GetResult>> {
        return try {
            val studentCourses = studentCourseService.getEntities(pageable)
            ResponseEntity.ok(studentCourses)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCourseDTOs.GetResult>> {
        return try {
            val studentCourse = studentCourseService.getEntityById(id, pageable)
            ResponseEntity.ok(studentCourse)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCourseDTOs.GetResult>> {
        return try {
            val studentCourse = studentCourseService.deleteEntityById(id, pageable)
            ResponseEntity.ok(studentCourse)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: StudentCourseDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCourseDTOs.GetResult>> {
        return try {
            val studentCourse = studentCourseService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(studentCourse)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: StudentCourseDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCourseDTOs.GetResult>> {
        return try {
            val studentCourse = studentCourseService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(studentCourse)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}