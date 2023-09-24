package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_moa_positions")
data class MOAPosition(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moa_id", referencedColumnName = "id", nullable = false)
    val moa: MOA,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", referencedColumnName = "id")
    val academicYear: AcademicYear?,

    @Column(name = "name", length = 255, nullable = false)
    val name: String,

    @Column(name = "requirements", columnDefinition = "TEXT")
    val requirements: String?,

    @Column(name = "students_accommodated")
    val studentsAccommodated: Int?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
