package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.MeetingStatusDTOs
import com.mmcm.projectocp.backend.spring.domain.service.MeetingStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/meeting-statuses")
class MeetingStatusController(
    private val meetingStatusService: MeetingStatusService
): EntityController<MeetingStatusDTOs.GetResult, MeetingStatusDTOs.PostRequest, MeetingStatusDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<MeetingStatusDTOs.GetResult>> {
        return try {
            val meetingStatus = meetingStatusService.getEntities(pageable)
            ResponseEntity.ok(meetingStatus)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingStatusDTOs.GetResult>> {
        return try {
            val meetingStatus = meetingStatusService.getEntityById(id, pageable)
            ResponseEntity.ok(meetingStatus)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: MeetingStatusDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingStatusDTOs.GetResult>> {
        return try {
            val meetingStatus = meetingStatusService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(meetingStatus)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: MeetingStatusDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingStatusDTOs.GetResult>> {
        return try {
            val meetingStatus = meetingStatusService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(meetingStatus)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingStatusDTOs.GetResult>> {
        return try {
            val meetingStatus = meetingStatusService.deleteEntityById(id, pageable)
            ResponseEntity.ok(meetingStatus)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}