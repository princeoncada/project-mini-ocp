package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.CompanyBranchDTOs
import com.mmcm.projectocp.backend.spring.domain.model.CompanyBranch
import com.mmcm.projectocp.backend.spring.domain.repository.*
import org.springframework.stereotype.Component
import java.time.Instant
import kotlin.jvm.optionals.getOrNull

@Component
class CompanyBranchMapper(
    private val companyRepository: CompanyRepository,
    private val countryRepository: CountryRepository,
    private val regionRepository: PhilippineRegionRepository,
    private val provinceRepository: PhilippineProvinceRepository,
    private val cityMunicipalityRepository: PhilippineCityMunicipalityRepository,
    private val barangayRepository: PhilippineBarangayRepository
): EntityMapper<CompanyBranch, CompanyBranchDTOs.GetResult, CompanyBranchDTOs.PostRequest, CompanyBranchDTOs.PutRequest> {
    override fun toGetResult(
        entity: CompanyBranch
    ): CompanyBranchDTOs.GetResult {
        return CompanyBranchDTOs.GetResult(
            id = entity.id,
            name = entity.name,
            company = entity.company.name,
            country = entity.country.name,
            address = entity.address,
            zipCode = entity.zipCode,
            isMainBranch = entity.isMainBranch,
            phone = entity.phone,
            email = entity.email,
            description = entity.description,
            region = entity.region?.name,
            province = entity.province?.name,
            cityMunicipality = entity.cityMunicipality?.name,
            barangay = entity.barangay?.name,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: CompanyBranchDTOs.PostRequest
    ): CompanyBranch {
        return CompanyBranch(
            id = id,
            name = entityRequest.name,
            company = companyRepository.findByName(entityRequest.company).get(),
            country = countryRepository.findByName(entityRequest.country).get(),
            address = entityRequest.address,
            zipCode = entityRequest.zipCode,
            isMainBranch = entityRequest.isMainBranch,
            phone = entityRequest.phone,
            email = entityRequest.email,
            description = entityRequest.description,
            region = regionRepository.findByName(entityRequest.region).getOrNull(),
            province = provinceRepository.findByName(entityRequest.province).getOrNull(),
            cityMunicipality = cityMunicipalityRepository.findByName(entityRequest.cityMunicipality).getOrNull(),
            barangay = barangayRepository.findByName(entityRequest.barangay).getOrNull(),
            createdAt = Instant.now(),
            updatedAt = Instant.now(),

        )
    }

    override fun updateEntity(
        entity: CompanyBranch,
        entityRequest: CompanyBranchDTOs.PutRequest
    ): CompanyBranch {
        return CompanyBranch(
            id = entity.id,
            name = entityRequest.name ?: entity.name,
            company = companyRepository.findByName(entityRequest.company ?: entity.company.name).get(),
            country = countryRepository.findByName(entityRequest.country ?: entity.country.name).get(),
            address = entityRequest.address ?: entity.address,
            zipCode = entityRequest.zipCode ?: entity.zipCode,
            isMainBranch = entityRequest.isMainBranch ?: entity.isMainBranch,
            phone = entityRequest.phone ?: entity.phone,
            email = entityRequest.email ?: entity.email,
            description = entityRequest.description ?: entity.description,
            region = regionRepository.findByName(entityRequest.region ?: entity.region?.name).getOrNull(),
            province = provinceRepository.findByName(entityRequest.province ?: entity.province?.name).getOrNull(),
            cityMunicipality = cityMunicipalityRepository.findByName(entityRequest.cityMunicipality ?: entity.cityMunicipality?.name).getOrNull(),
            barangay = barangayRepository.findByName(entityRequest.barangay ?: entity.barangay?.name).getOrNull(),
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}