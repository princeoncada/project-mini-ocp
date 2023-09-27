package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.MeetingTypeDTOs
import com.mmcm.projectocp.backend.spring.domain.service.MeetingTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/meeting-types")
class MeetingTypeController (
    private val meetingTypeService: MeetingTypeService
): EntityController<MeetingTypeDTOs.GetResult, MeetingTypeDTOs.PostRequest, MeetingTypeDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<MeetingTypeDTOs.GetResult>> {
        return try {
            val meetingType = meetingTypeService.getEntities(pageable)
            ResponseEntity.ok(meetingType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingTypeDTOs.GetResult>> {
        return try {
            val meetingType = meetingTypeService.getEntityById(id, pageable)
            ResponseEntity.ok(meetingType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: MeetingTypeDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingTypeDTOs.GetResult>> {
        return try {
            val meetingType = meetingTypeService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(meetingType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: MeetingTypeDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingTypeDTOs.GetResult>> {
        return try {
            val meetingType = meetingTypeService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(meetingType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<MeetingTypeDTOs.GetResult>> {
        return try {
            val meetingType = meetingTypeService.deleteEntityById(id, pageable)
            ResponseEntity.ok(meetingType)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}