package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tbl_roles")
data class Role(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "name", length = 255, nullable = false, unique = true)
    val name: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)