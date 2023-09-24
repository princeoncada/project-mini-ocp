package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.CountryDTOs
import com.mmcm.projectocp.backend.spring.domain.service.CountryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/countries")
class CountryController(
    private val countryService: CountryService
): EntityController<CountryDTOs.GetResult, CountryDTOs.PostRequest, CountryDTOs.PutRequest> {
    override fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<CountryDTOs.GetResult>> {
        return try {
            val countries = countryService.getEntities(pageable)
            ResponseEntity.ok(countries)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun getEntityById(id: String, pageable: Pageable): ResponseEntity<Page<CountryDTOs.GetResult>> {
        return try {
            val country = countryService.getEntityById(id, pageable)
            ResponseEntity.ok(country)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun createEntity(
        entityRequest: CountryDTOs.PostRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CountryDTOs.GetResult>> {
        return try {
            val country = countryService.createEntity(entityRequest, pageable)
            ResponseEntity.ok(country)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: CountryDTOs.PutRequest,
        pageable: Pageable
    ): ResponseEntity<Page<CountryDTOs.GetResult>> {
        return try {
            val country = countryService.updateEntityById(id, entityRequest, pageable)
            ResponseEntity.ok(country)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    override fun deleteEntityById(id: String, pageable: Pageable): ResponseEntity<Page<CountryDTOs.GetResult>> {
        return try {
            val country = countryService.deleteEntityById(id, pageable)
            ResponseEntity.ok(country)
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }
}