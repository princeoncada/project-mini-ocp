package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.MeetingDTOs
import com.mmcm.projectocp.backend.spring.domain.service.MeetingService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/meetings")
class MeetingController(
    private val meetingService: MeetingService
): EntityController<MeetingDTOs.GetResult, MeetingDTOs.PostRequest, MeetingDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<MeetingDTOs.GetResult>> {
        return try {
            val entities = meetingService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingDTOs.GetResult>> {
        return try {
            val entities = meetingService.getEntityById(id, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingDTOs.GetResult>> {
        return try {
            val entities = meetingService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: MeetingDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingDTOs.GetResult>> {
        return try {
            val entities = meetingService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: MeetingDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingDTOs.GetResult>> {
        return try {
            val entities = meetingService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}