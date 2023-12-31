package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineProvinceDTOs
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineProvinceService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/philippine-provinces")
class PhilippineProvinceController(
    private val philippineProvinceService: PhilippineProvinceService
): EntityController<PhilippineProvinceDTOs.GetResult, PhilippineProvinceDTOs.PostRequest, PhilippineProvinceDTOs.PutRequest> {
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineProvinceDTOs.GetResult>> {
        return try {
            val entities = philippineProvinceService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineProvinceDTOs.GetResult>> {
        return try {
            val entity = philippineProvinceService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: PhilippineProvinceDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineProvinceDTOs.GetResult>> {
        return try {
            val entity = philippineProvinceService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: PhilippineProvinceDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineProvinceDTOs.GetResult>> {
        return try {
            val entity = philippineProvinceService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineProvinceDTOs.GetResult>> {
        return try {
            val entity = philippineProvinceService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}