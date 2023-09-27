package com.mmcm.projectocp.backend.spring.config.service

import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler

class CustomLogoutSuccessHandler(
    private val userRepository: UserRepository,
    private val jwtService: JwtService
): LogoutSuccessHandler {
    override fun onLogoutSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        userRepository.findByEmail(authentication?.name).get().let { user ->
            jwtService.revokeRefreshToken(user.id)
        }
        jwtService.clearAccessTokenCookie(response!!)
        SecurityContextHolder.clearContext()
        response.sendRedirect("/login?logout")
    }
}