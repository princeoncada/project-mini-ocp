package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tbl_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "email", length = 255, nullable = false, unique = true)
    val email: String,

    @Column(name = "first_name", length = 255, nullable = false)
    val firstName: String,

    @Column(name = "last_name", length = 255, nullable = false)
    val lastName: String,

    @Column(name = "student_id", length = 255, unique = true)
    val studentId: String,

    @Column(name = "designation", length = 255)
    val designation: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)