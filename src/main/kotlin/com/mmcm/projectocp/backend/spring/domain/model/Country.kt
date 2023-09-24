package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_countries")
data class Country(
    @Id
    @Column(name = "id", length = 36,)
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,

    @Column(name = "iso_code", length = 255, nullable = false, unique = true)
    val isoCode: String,

    @Column(name = "name", length = 255, nullable = false, unique = true)
    val name: String,

    @CreationTimestamp
    @Column(name = "created_at")
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Instant
)
