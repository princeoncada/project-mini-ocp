package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_academic_years")
open class AcademicYear {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    open lateinit var id: String

    @Column(name = "year_from", nullable = false)
    open var yearFrom: Int? = null

    @Column(name = "year_to", nullable = false)
    open var yearTo: Int? = null

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    open lateinit var createdAt: Instant

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    open lateinit var updatedAt: Instant
}
