package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.*


@Entity
@Table(name = "tbl_user_roles")
open class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open lateinit var id: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    open lateinit var userEntity: UserEntity

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    open lateinit var role: Role
}