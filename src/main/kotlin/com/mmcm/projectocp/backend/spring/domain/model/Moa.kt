package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "tbl_moas")
data class Moa(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", referencedColumnName = "id", nullable = false)
    val branch: CompanyBranch,

    @Column(name = "title", length = 255)
    val title: String?,

    @Column(name = "start_date")
    val startDate: LocalDate?,

    @Column(name = "expiry_date")
    val expiryDate: LocalDate?,

    @Column(name = "description", columnDefinition = "TEXT")
    val description: String?,

    @Column(name = "vpaa_submission")
    val vpaaSubmission: LocalDate?,

    @Column(name = "is_active")
    val isActive: Boolean = false,

    @Column(name = "is_hiring", nullable = false)
    val isHiring: Boolean = false,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
