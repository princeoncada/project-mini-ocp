package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import jakarta.persistence.*
import java.time.Instant

@Entity
@Table(name = "tbl_moa_position_programs")
data class MOAPositionProgram(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    val program: Program,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moa_position_id", referencedColumnName = "id", nullable = false)
    val moaPosition: MOAPosition,

    @Column(name = "students_accommodated")
    val studentsAccommodated: Int?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
