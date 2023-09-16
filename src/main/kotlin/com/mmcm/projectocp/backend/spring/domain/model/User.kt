package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tbl_users")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open lateinit var id: String

    @Column
    open lateinit var email: String

    @Column
    open lateinit var firstName: String

    @Column
    open lateinit var lastName: String

    @Column
    open lateinit var studentId: String

    @Column
    open lateinit var designation: String

    @CreationTimestamp
    open lateinit var createdAt: Instant

    @UpdateTimestamp
    open lateinit var updatedAt: Instant
}