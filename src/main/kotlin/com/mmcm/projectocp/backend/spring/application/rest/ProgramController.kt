package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.ProgramDTOs
import com.mmcm.projectocp.backend.spring.domain.service.ProgramService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/programs")
class ProgramController(
    private val programService: ProgramService
): EntityController<ProgramDTOs.GetResult, ProgramDTOs.PostRequest, ProgramDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<ProgramDTOs.GetResult>> {
        return try {
            val programs = programService.getEntities(pageable)
            ResponseEntity.ok(programs)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<ProgramDTOs.GetResult>> {
        return try {
            val program = programService.getEntityById(id, pageable)
            ResponseEntity.ok(program)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: ProgramDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<ProgramDTOs.GetResult>> {
        return try {
            val program = programService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(program)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: ProgramDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<ProgramDTOs.GetResult>> {
        return try {
            val program = programService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(program)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<ProgramDTOs.GetResult>> {
        return try {
            val program = programService.deleteEntityById(id, pageable)
            ResponseEntity.ok(program)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}