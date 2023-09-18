package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserPrincipal(
    private val userRole: UserRole
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities: MutableCollection<GrantedAuthority> = mutableListOf()
        authorities.add(GrantedAuthority { userRole.role.name })
        return authorities
    }

    override fun getPassword(): String {
        return ""
    }


    override fun getUsername(): String {
        return userRole.user.email
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