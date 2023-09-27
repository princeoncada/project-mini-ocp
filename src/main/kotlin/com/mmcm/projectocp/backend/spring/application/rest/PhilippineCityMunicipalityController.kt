package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.PhilippineCityMunicipalityDTOs
import com.mmcm.projectocp.backend.spring.domain.service.PhilippineCityMunicipalityService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/philippine-city-municipality")
class PhilippineCityMunicipalityController(
    private val philippineCityMunicipalityService: PhilippineCityMunicipalityService
): EntityController<PhilippineCityMunicipalityDTOs.GetResult, PhilippineCityMunicipalityDTOs.PostRequest, PhilippineCityMunicipalityDTOs.PutRequest>{
    @GetMapping
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineCityMunicipalityDTOs.GetResult>> {
        return try {
            val entities = philippineCityMunicipalityService.getEntities(pageable)
            ResponseEntity.ok(entities)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @GetMapping("/{id}")
    override fun getEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineCityMunicipalityDTOs.GetResult>> {
        return try {
            val entity = philippineCityMunicipalityService.getEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping
    override fun createEntity(
        @RequestBody entityRequest: PhilippineCityMunicipalityDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineCityMunicipalityDTOs.GetResult>> {
        return try {
            val entity = philippineCityMunicipalityService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @PutMapping("/{id}")
    override fun updateEntityById(
        @PathVariable id: String,
        @RequestBody entityRequest: PhilippineCityMunicipalityDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineCityMunicipalityDTOs.GetResult>> {
        return try {
            val entity = philippineCityMunicipalityService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }

    @DeleteMapping("/{id}")
    override fun deleteEntityById(
        @PathVariable id: String,
        pageable: Pageable
    ): ResponseEntity<Page<PhilippineCityMunicipalityDTOs.GetResult>> {
        return try {
            val entity = philippineCityMunicipalityService.deleteEntityById(id, pageable)
            ResponseEntity.ok(entity)
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }
    }
}