package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.MoaPositionProgramDTOs
import com.mmcm.projectocp.backend.spring.domain.service.MoaPositionProgramService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/moa-position-programs")
class MoaPositionProgramController(
    private val moaPositionProgramService: MoaPositionProgramService
): EntityController<MoaPositionProgramDTOs.GetResult, MoaPositionProgramDTOs.PostRequest, MoaPositionProgramDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionProgramDTOs.GetResult>> {
        return try {
            val moaPositionPrograms = moaPositionProgramService.getEntities(pageable)
            ResponseEntity.ok(moaPositionPrograms)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionProgramDTOs.GetResult>> {
        return try {
            val moaPositionProgram = moaPositionProgramService.getEntityById(id, pageable)
            ResponseEntity.ok(moaPositionProgram)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionProgramDTOs.GetResult>> {
        return try {
            val moaPositionProgram = moaPositionProgramService.deleteEntityById(id, pageable)
            ResponseEntity.ok(moaPositionProgram)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: MoaPositionProgramDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionProgramDTOs.GetResult>> {
        return try {
            val moaPositionProgram = moaPositionProgramService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(moaPositionProgram)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: MoaPositionProgramDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MoaPositionProgramDTOs.GetResult>> {
        return try {
            val moaPositionProgram = moaPositionProgramService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(moaPositionProgram)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}