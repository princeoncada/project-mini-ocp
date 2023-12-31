package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_companies")
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "name", length = 255, nullable = false, unique = true)
    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_category_id", referencedColumnName = "id", nullable = false)
    val companyCategory: CompanyCategory,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_type_id", referencedColumnName = "id", nullable = false)
    val industryType: IndustryType,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
