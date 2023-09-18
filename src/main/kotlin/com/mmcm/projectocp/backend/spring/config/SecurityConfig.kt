package com.mmcm.projectocp.backend.spring.config

import com.mmcm.projectocp.backend.spring.domain.service.CustomUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val customUserDetailsService: CustomUserDetailsService
) {

    private final val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    val user: UserDetails = User
        .withUsername("user")
        .username("user")
        .password(encoder.encode("pass"))
        .roles("USER")
        .build()

    val admin: UserDetails = User
        .withUsername("admin")
        .username("admin")
        .password(encoder.encode("pass"))
        .roles("ADMIN")
        .authorities("GET")
        .build()

    @Bean
    fun users(): UserDetailsService {
        val users = InMemoryUserDetailsManager()
        users.createUser(user)
        users.createUser(admin)
        return users
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    fun auth(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder())
    }

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            oauth2Login {
                userInfoEndpoint {
                    userAuthoritiesMapper = grantedAuthoritiesMapper()
                }
            }
            csrf { disable() }
            authorizeRequests {
                authorize("/", authenticated)
//                authorize("/api/user/**" , hasRole("admin"))
            }
            formLogin {  }
            httpBasic {  }
            logout {  }
        }
        return http.build()
    }

    private fun grantedAuthoritiesMapper(): GrantedAuthoritiesMapper {
        return GrantedAuthoritiesMapper { authorities ->
            val mappedAuthorities = mutableListOf<GrantedAuthority>()
            mappedAuthorities.add(GrantedAuthority {"admin"})
            for (authority in authorities) {
                when (authority) {
                    is OidcUserAuthority ->
                        mappedAuthorities.add(OidcUserAuthority("OIDC_USER", authority.idToken, authority.userInfo))
                    is OAuth2UserAuthority ->
                        mappedAuthorities.add(OAuth2UserAuthority("OAUTH2_USER", authority.attributes))
                    else -> mappedAuthorities.add(authority)
                }
            }

            mappedAuthorities
        }
    }
}