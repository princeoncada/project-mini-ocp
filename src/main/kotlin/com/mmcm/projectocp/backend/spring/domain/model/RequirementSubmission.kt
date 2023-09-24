package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tbl_req_submissions")
data class RequirementSubmission(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_course_id", referencedColumnName = "id", nullable = false)
    val studentCourse: StudentCourse,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requirement_id", referencedColumnName = "id", nullable = false)
    val requirement: Requirement,

    @Column(name = "status", nullable = false)
    val status: Int,

    @Column(name = "message", columnDefinition = "TEXT")
    val message: String?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
