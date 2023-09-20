package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tbl_contents")
data class Content(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_type_id", referencedColumnName = "id", nullable = false)
    val contentType: ContentType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
    val author: User,

    @Column(name = "title", length = 255)
    val title: String?,

    @Column(name = "content", columnDefinition = "TEXT")
    val content: String?,

    @Column(name = "is_active")
    val isActive: Boolean?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
