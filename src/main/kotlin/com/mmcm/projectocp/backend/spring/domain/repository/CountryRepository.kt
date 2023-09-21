package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CountryRepository : JpaRepository<Country, String> {
    // You can add custom query methods here if needed

    fun findByName(name: String): List<Country>

    fun findByIsoCode(isoCode: String): List<Country>

    fun findByNameAndIsoCode(name: String, isoCode: String): List<Country>
}
