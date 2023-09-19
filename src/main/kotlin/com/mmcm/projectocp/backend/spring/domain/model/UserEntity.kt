package com.mmcm.projectocp.backend.spring.domain.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.Instant

@Entity
@Table(name = "tbl_users")
open class UserEntity : UserDetails {
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "tbl_user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    open var roles: MutableSet<Role> = mutableSetOf()

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
    @JoinTable(
        name = "tbl_user_permissions",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "permission_id")]
    )
    open var permissions: MutableSet<Permission> = mutableSetOf()
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities = mutableSetOf<GrantedAuthority>()
        authorities.addAll(roles)
        authorities.addAll(permissions)
        return authorities
    }

    override fun getPassword(): String {
        return studentId
    }

    override fun getUsername(): String {
        return email
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}