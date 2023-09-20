package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tbl_student_courses")
data class StudentCourse(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false)
    val course: Course,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adviser_id", referencedColumnName = "id")
    val adviser: User?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    val program: Program,

    @Column(name = "email", length = 255, nullable = false)
    val email: String,

    @Column(name = "student_id", length = 255, nullable = false)
    val studentId: String,

    @Column(name = "is_finished")
    val isFinished: Boolean?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
