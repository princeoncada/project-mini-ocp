package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.StudentCompanyAttendanceDTOs
import com.mmcm.projectocp.backend.spring.domain.service.StudentCompanyAttendanceService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/student-company-attendances")
class StudentCompanyAttendanceController(
    private val studentCompanyAttendanceService: StudentCompanyAttendanceService
): EntityController<StudentCompanyAttendanceDTOs.GetResult, StudentCompanyAttendanceDTOs.PostRequest, StudentCompanyAttendanceDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<StudentCompanyAttendanceDTOs.GetResult>> {
        return try {
            val studentCompanyAttendances = studentCompanyAttendanceService.getEntities(pageable)
            ResponseEntity.ok(studentCompanyAttendances)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCompanyAttendanceDTOs.GetResult>> {
        return try {
            val studentCompanyAttendance = studentCompanyAttendanceService.getEntityById(id, pageable)
            ResponseEntity.ok(studentCompanyAttendance)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCompanyAttendanceDTOs.GetResult>> {
        return try {
            val studentCompanyAttendance = studentCompanyAttendanceService.deleteEntityById(id, pageable)
            ResponseEntity.ok(studentCompanyAttendance)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: StudentCompanyAttendanceDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCompanyAttendanceDTOs.GetResult>> {
        return try {
            val studentCompanyAttendance = studentCompanyAttendanceService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(studentCompanyAttendance)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: StudentCompanyAttendanceDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<StudentCompanyAttendanceDTOs.GetResult>> {
        return try {
            val studentCompanyAttendance = studentCompanyAttendanceService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(studentCompanyAttendance)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}