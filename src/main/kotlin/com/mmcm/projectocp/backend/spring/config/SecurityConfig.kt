package com.mmcm.projectocp.backend.spring.config

import com.mmcm.projectocp.backend.spring.config.service.*
import com.mmcm.projectocp.backend.spring.domain.repository.RefreshTokenRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtService: JwtService,
    private val userPrincipalService: CustomPrincipalService,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val userRepository: UserRepository
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            csrf { disable() }
            authorizeRequests {
//                authorize("/api/users/**", hasRole("admin"))
                authorize(anyRequest, authenticated)
            }
            sessionManagement {
                SessionCreationPolicy.STATELESS
            }
            oauth2Login {
                userInfoEndpoint {
                    oidcUserService = oidcUserService()
                }
                defaultSuccessUrl("/oauth2/callback", true)
            }
            addFilterBefore<UsernamePasswordAuthenticationFilter>(
                JwtAuthenticationFilter(
                    jwtService,
                    userPrincipalService,
                    refreshTokenRepository
                )
            )
            logout {
                logoutUrl = "/logout"
                logoutSuccessHandler = CustomLogoutSuccessHandler(userRepository, jwtService)
                permitAll()
            }
        }
        return http.build()
    }

    @Bean
    fun oidcUserService(): OidcUserService {
        val delegate = OidcUserService()
        return CustomOidcUserService(delegate)
    }
}