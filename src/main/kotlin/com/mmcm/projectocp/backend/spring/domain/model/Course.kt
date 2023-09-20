package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tbl_courses")
data class Course(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", referencedColumnName = "id", nullable = false)
    val academicYear: AcademicYear,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id", referencedColumnName = "id", nullable = false)
    val term: Term,

    @Column(name = "name", length = 255, nullable = false)
    val name: String,

    @Column(name = "code", length = 255, nullable = false)
    val code: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    val instructor: User?,

    @Column(name = "is_active", nullable = false)
    val isActive: Boolean,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
