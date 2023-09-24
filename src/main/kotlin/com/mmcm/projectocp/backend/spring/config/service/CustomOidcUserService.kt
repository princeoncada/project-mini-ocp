package com.mmcm.projectocp.backend.spring.config.service

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser
import org.springframework.security.oauth2.core.oidc.user.OidcUser

class CustomOidcUserService(
    private val delegate: OidcUserService
): OidcUserService() {
        override fun loadUser(userRequest: OidcUserRequest): OidcUser {
            val oidcUser = delegate.loadUser(userRequest)
            val idToken = oidcUser.idToken
            return DefaultOidcUser(oidcUser.authorities, idToken, "email")
        }
}