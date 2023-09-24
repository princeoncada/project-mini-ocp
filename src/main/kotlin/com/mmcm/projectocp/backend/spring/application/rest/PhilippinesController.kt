package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineProvince
import com.mmcm.projectocp.backend.spring.domain.model.PhilippineRegion
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineBarangayRepository
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineMunicipalityRepository
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineProvinceRepository
import com.mmcm.projectocp.backend.spring.domain.repository.PhilippineRegionRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

// TODO: add POST, PUT and DELETE methods
// its in the works, but for now, this is just a proof of concept
// Goods ba or separate na lang?
@RestController
@RequestMapping("/api/philippines")
class PhilippinesController(
    private val philippineRegionRepository: PhilippineRegionRepository,
    private val philippineProvinceRepository: PhilippineProvinceRepository,
    private val philippineMunicipalityRepository: PhilippineMunicipalityRepository,
    private val philippineBarangayRepository: PhilippineBarangayRepository
){
    // Regions
    @GetMapping("/get-philippines-regions")
    fun getPhilRegions(): List<String> {
        return philippineRegionRepository.findAll().map { it.name }
    }

    @GetMapping("/get-philippines-regions/id={regionId}")
    fun getPhilRegionsById(@PathVariable regionId: String): PhilippineRegion {
        return philippineRegionRepository.findById(regionId).orElseThrow() { Exception("Region not found")}
    }

    @GetMapping("/get-philippines-regions/reg-code={regcode}")
    fun getPhilRegionsByRegCode(@PathVariable regcode: String): PhilippineRegion {
        return philippineRegionRepository.findByRegionCode(regcode).orElseThrow() { Exception("Region Code not found")}
    }

    // Provinces
    @GetMapping("/get-philippines-provinces")
    fun getPhilProvinces(): List<String> {
        return philippineProvinceRepository.findAll().map { it.name }
    }

    @GetMapping("/get-philippines-provinces/id={provinceId}")
    fun getPhilProvincesById(@PathVariable provinceId: String): PhilippineProvince {
        return philippineProvinceRepository.findById(provinceId).orElseThrow() { Exception("Province not found")}
    }

    @GetMapping("/get-philippines-provinces/prov-code={provcode}")
    fun getPhilProvincesByProvCode(@PathVariable provcode: String): PhilippineProvince {
        return philippineProvinceRepository.findByProvinceCode(provcode).orElseThrow() { Exception("Province Code not found")}
    }

    // Municipalities
    @GetMapping("/get-philippines-municipalities")
    fun getPhilMunicipalities(): List<String> {
        return philippineMunicipalityRepository.findAll().map { it.name }
    }

    @GetMapping("/get-philippines-municipalities/id={municipalityId}")
    fun getPhilMunicipalitiesById(@PathVariable municipalityId: String): Optional<PhilippineRegion> {
        return philippineRegionRepository.findById(municipalityId)
    }

    // Barangays
    @GetMapping("/get-philippines-barangays")
    fun getPhilBarangays(): List<String> {
        return philippineBarangayRepository.findAll().map { it.name }
    }

    @GetMapping("/get-philippines-barangays/id={barangayId}")
    fun getPhilBarangaysById(@PathVariable barangayId: String): Optional<PhilippineRegion> {
        return philippineRegionRepository.findById(barangayId)
    }





}