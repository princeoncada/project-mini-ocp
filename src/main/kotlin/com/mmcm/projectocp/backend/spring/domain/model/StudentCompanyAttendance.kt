package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant
import java.time.LocalDate

@Entity
@Table(name = "tbl_student_companies_attended")
data class StudentCompanyAttendance(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_course_id", referencedColumnName = "id", nullable = false)
    val studentCourse: StudentCourse,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moa_id", referencedColumnName = "id", nullable = false)
    val moa: MOA,

    @Column(name = "designation", length = 255, nullable = false)
    val designation: String,

    @Column(name = "hours", nullable = false)
    val hours: Int,

    @Column(name = "date_start", nullable = false)
    val dateStart: LocalDate,

    @Column(name = "date_end")
    val dateEnd: LocalDate?,

    @Column(name = "finished_at")
    val finishedAt: LocalDate?,

    @Column(name = "cancelled_at")
    val cancelledAt: LocalDate?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
