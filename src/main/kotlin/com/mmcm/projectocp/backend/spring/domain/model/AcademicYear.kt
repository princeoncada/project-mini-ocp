package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_academic_years")
data class AcademicYear(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "year_from", nullable = false)
    val yearFrom: Int,

    @Column(name = "year_to", nullable = false)
    val yearTo: Int,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
