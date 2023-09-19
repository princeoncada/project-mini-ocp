package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "tbl_phil_provinces")
data class PhilippineProvince(
    @Id
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @Column(name = "prov_code", length = 255, nullable = false)
    val provinceCode: String,

    @Column(name = "reg_code", length = 255, nullable = false)
    val regionCode: String,

    @Column(name = "name", length = 255, nullable = false)
    val name: String,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
