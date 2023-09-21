package com.mmcm.projectocp.backend.spring.domain.model
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tbl_departments")
open class Department(
    @Id
    @Column(name = "id", length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    open val id: String,

    @Column(name = "name", length = 255, nullable = false, unique = true)
    open val name: String,

    @Column(name = "abbr", length = 255, nullable = false, unique = true)
    open val abbr: String,

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    open val createdAt: Instant,

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    open val updatedAt: Instant
)
