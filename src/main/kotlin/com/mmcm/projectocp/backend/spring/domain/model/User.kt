package com.mmcm.projectocp.backend.spring.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tbl_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: String,

    @Column
    val email: String,

    @Column
    val firstName: String,

    @Column
    val lastName: String,

    @Column
    val studentId: String,

    @Column
    val designation: String,

    @Column
    @CreationTimestamp
    val createdAt: Instant,

    @Column
    @UpdateTimestamp
    val updatedAt: Instant
)