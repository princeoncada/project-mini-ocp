package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tbl_user_emails")
data class UserEmail(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    val user: User,

    @Column(name = "email", length = 255, nullable = false, unique = true)
    val email: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
