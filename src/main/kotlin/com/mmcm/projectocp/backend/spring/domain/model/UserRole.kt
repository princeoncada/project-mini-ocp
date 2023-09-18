package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tbl_user_roles")
data class UserRole(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @OneToOne
    @JoinColumn(name = "role_id")
    val role: Role,

    @Column
    @CreationTimestamp
    val createdAt: Instant,

    @Column
    @UpdateTimestamp
    val updatedAt: Instant
)