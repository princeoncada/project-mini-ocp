package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "tbl_permissions")
open class Permission : GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open lateinit var id: String

    @Column
    open lateinit var name: String

    @Column
    open lateinit var createdAt: String

    @Column
    open lateinit var updatedAt: String
    override fun getAuthority(): String {
        return name
    }
}
