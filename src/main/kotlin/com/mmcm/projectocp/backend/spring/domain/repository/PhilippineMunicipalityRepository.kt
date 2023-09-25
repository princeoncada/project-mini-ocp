package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineCityMunicipality
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhilippineMunicipalityRepository: JpaRepository<PhilippineCityMunicipality, String> {
}
