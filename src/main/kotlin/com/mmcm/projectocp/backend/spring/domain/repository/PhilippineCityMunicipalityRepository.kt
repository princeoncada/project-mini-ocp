package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineCityMunicipality
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhilippineCityMunicipalityRepository: JpaRepository<PhilippineCityMunicipality, String> {
    fun findById(id: String, pageable: Pageable): Page<PhilippineCityMunicipality>
}