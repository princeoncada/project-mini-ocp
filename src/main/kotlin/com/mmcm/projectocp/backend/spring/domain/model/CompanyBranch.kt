package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_company_branches")
data class CompanyBranch(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "name", length = 255, nullable = false)
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    val company: Company,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    val country: Country,

    @Column(name = "address", length = 255)
    val address: String?,

    @Column(name = "zip_code", length = 255)
    val zipCode: String?,

    @Column(name = "is_main_branch")
    val isMainBranch: Boolean?,

    @Column(name = "phone", length = 255)
    val phone: String?,

    @Column(name = "email", length = 255)
    val email: String?,

    @Column(name = "description", columnDefinition = "TEXT")
    val description: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    val region: PhilippineRegion?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    val province: PhilippineProvince?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_mun_id", referencedColumnName = "id")
    val cityMunicipality: PhilippineCityMunicipality?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barangay_id", referencedColumnName = "id")
    val barangay: PhilippineBarangay?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
