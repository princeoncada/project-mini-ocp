package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.CountryDTO
import com.mmcm.projectocp.backend.spring.domain.model.Country
import com.mmcm.projectocp.backend.spring.domain.repository.CountryRepository
import com.mmcm.projectocp.backend.spring.domain.service.CountryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/country")
class CountryController(
    private val countryRepository: CountryRepository,
    private val countryService: CountryService
) {
    @GetMapping("/get-countries")
    fun getCountries(pageable: Pageable) : Page<CountryDTO> {
        return countryRepository.findAll(pageable).map { CountryDTO(it.id, it.isoCode, it.name) }
    }

    @GetMapping("/get-countries", params = ["countries", "iso-code"])
    fun getCountriesByNameAndIsoCode(
        @RequestParam("countries") countries: String,
        @RequestParam("iso-code") isoCode: String,
    ) : List<Country> {
        return countryRepository.findByNameAndIsoCode(countries, isoCode)
    }

    //Not working due to IsoCode or semethjing in the model
    @PostMapping("/create-country")
    fun createCountry(@RequestBody countryDto: CountryDTO) : CountryDTO {
        return countryService.createCountry(countryDto)
    }

    @PutMapping("/update-country/id={id}")
    fun updateCountry(
        @PathVariable("id") id: String,
        @RequestBody countryDto: CountryDTO
    ) : CountryDTO {
        return countryService.updateCountryById(id, countryDto)
    }

    @DeleteMapping("/delete-country/id={id}")
    fun deleteCountry(
        @PathVariable("id") id: String) {
        countryService.deleteCountryById(id)
    }


}