package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tbl_sessions")
data class Session(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    val user: User,

    @Column(name = "expires_on", nullable = false)
    val expiresOn: LocalDateTime,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant,
)
