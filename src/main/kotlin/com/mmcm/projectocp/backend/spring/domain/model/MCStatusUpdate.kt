package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "tbl_mc_status_updates")
data class MCStatusUpdate(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mc_status_id", referencedColumnName = "id", nullable = false)
    val mcStatus: MCStatus,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moa_id", referencedColumnName = "id", nullable = false)
    val moa: MOA,

    @Column(name = "notes", columnDefinition = "TEXT")
    val notes: String?,

    @Column(name = "mc_approved_date")
    val mcApprovedDate: LocalDate?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
