package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.PhilippineCityMunicipality
import org.springframework.data.jpa.repository.JpaRepository

interface PhilippineMunicipalityRepository : JpaRepository<PhilippineCityMunicipality, String> {
    // You can add custom query methods here if needed
}
