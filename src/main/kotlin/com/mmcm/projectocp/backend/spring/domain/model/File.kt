package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_files")
data class File(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_type_id", referencedColumnName = "id", nullable = false)
    val fileType: FileType,

    @Column(name = "parent_id", length = 36, nullable = false)
    val parentId: String,

    @Column(name = "name", columnDefinition = "TEXT", nullable = false)
    val name: String,

    @Column(name = "mimetype", length = 255, nullable = false)
    val mimetype: String,

    @Column(name = "path", columnDefinition = "TEXT", nullable = false)
    val path: String,

    @Column(name = "key", columnDefinition = "TEXT", nullable = false)
    val key: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by", referencedColumnName = "id", nullable = false)
    val uploadedBy: User,

    @Column(name = "order")
    val order: Int?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
