package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tbl_moa_partnership_types")
data class MoaPartnershipType(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moa_id", referencedColumnName = "id", nullable = false)
    val moa: Moa,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partnership_type_id", referencedColumnName = "id", nullable = false)
    val partnershipType: PartnershipType,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
