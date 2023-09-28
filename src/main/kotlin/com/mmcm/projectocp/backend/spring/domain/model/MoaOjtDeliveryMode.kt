package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_moa_ojt_delivery_modes")
data class MoaOjtDeliveryMode(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moa_id", referencedColumnName = "id", nullable = false)
    val moa: Moa,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ojt_delivery_mode_id", referencedColumnName = "id", nullable = false)
    val ojtDeliveryMode: OjtDeliveryMode,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
