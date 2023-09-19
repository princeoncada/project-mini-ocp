package com.mmcm.projectocp.backend.spring.domain.model
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tbl_departments")
data class Department(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "name", length = 255, nullable = false, unique = true)
    val name: String,

    @Column(name = "abbr", length = 255, nullable = false, unique = true)
    val abbr: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
