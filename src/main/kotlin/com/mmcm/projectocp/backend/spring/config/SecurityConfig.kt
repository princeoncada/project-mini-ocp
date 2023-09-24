package com.mmcm.projectocp.backend.spring.config

import com.mmcm.projectocp.backend.spring.config.service.CustomOidcUserService
import com.mmcm.projectocp.backend.spring.config.service.JwtAuthenticationFilter
import com.mmcm.projectocp.backend.spring.config.service.JwtService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtService: JwtService
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            csrf { disable() }
            authorizeRequests {
//                authorize("/api/users/**", hasRole("admin"))
                authorize(anyRequest, authenticated)
            }
            oauth2Login {
                userInfoEndpoint {
                    oidcUserService = oidcUserService()
                }
                defaultSuccessUrl("/authenticate", true)
            }
            addFilterBefore<UsernamePasswordAuthenticationFilter>(JwtAuthenticationFilter(jwtService))
        }
        return http.build()
    }

    @Bean
    fun oidcUserService(): OidcUserService {
        val delegate = OidcUserService()
        return CustomOidcUserService(delegate)
    }
}