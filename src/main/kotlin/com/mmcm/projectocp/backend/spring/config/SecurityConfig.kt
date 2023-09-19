package com.mmcm.projectocp.backend.spring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig{

    private final val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

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

    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            oauth2Login { }
            csrf { disable() }
            authorizeRequests {
//                authorize("/", authenticated)
                authorize("/api/user/**" , hasRole("admin"))
            }
            httpBasic {  }
            logout {  }
        }
        return http.build()
    }
}