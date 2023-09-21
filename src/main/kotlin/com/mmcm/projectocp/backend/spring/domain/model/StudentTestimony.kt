package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "tbl_student_testimonies")
data class StudentTestimony(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "student_companies_attended_id", length = 36, nullable = false, unique = true)
    val studentCompaniesAttendedId: String,

    @Column(name = "review", columnDefinition = "TEXT")
    val review: String? = null,

    @Column(name = "rating", nullable = false)
    val rating: Int,

    @Column(name = "date_approved")
    val dateApproved: LocalDate? = null,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
