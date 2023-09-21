package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_company_contact_persons")
data class CompanyContactPerson(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    val company: Company,

    @Column(name = "name", length = 255, nullable = false)
    val name: String,

    @Column(name = "designation", length = 255)
    val designation: String?,

    @Column(name = "email", length = 255)
    val email: String?,

    @Column(name = "phone", length = 255)
    val phone: String?,

    @Column(name = "is_active", nullable = false)
    val isActive: Boolean,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
