package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_ojt_delivery_modes")
data class OjtDeliveryMode(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "mode", length = 255, nullable = false, unique = true)
    val mode: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)