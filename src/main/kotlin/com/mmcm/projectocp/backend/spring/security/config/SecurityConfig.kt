package com.mmcm.projectocp.backend.spring.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


// TODO: Add security configuration here Auths and Stuff
// NOTES: This is a temporary security config for testing purposes
// I magic ra nako na later

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtRequestFilter: JwtRequestFilter,
    private val applicationConfig: ApplicationConfig

) {


    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
//            .cors {
//                it.configurationSource(corsConfigurationSource())
//            }
            .csrf {
                it.disable()
            }

            .authorizeHttpRequests {

//                it.requestMatchers("/user/register").permitAll()
//                it.requestMatchers("/user/signin").permitAll()
                it.requestMatchers(
                    "/api/auth/register",
                    "/api/auth/login")
                    .permitAll()
                it.requestMatchers("/user/get-auth/admin").hasAuthority("admin")
                it.requestMatchers("/user/get-auth/student").hasAuthority("student")


                it.requestMatchers("/user/get-users?role=*").hasAuthority("admin")
//
//
//                it.requestMatchers("/user/get-auth").permitAll()
                it.anyRequest().authenticated()

            }
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authenticationProvider(applicationConfig.authenticationProvider())
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }


//    @Bean
//    fun corsConfigurationSource(): CorsConfigurationSource {
//        val configuration = CorsConfiguration()
//        configuration.allowedOrigins = listOf("*")
//        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
//        configuration.allowedHeaders = listOf("content-type", "authorization", "X-Access-Token")
//        // Allow client to write to header
//        configuration.exposedHeaders = listOf("X-Access-Token")
//        val source = UrlBasedCorsConfigurationSource()
//        source.registerCorsConfiguration("/**", configuration)
//        return source
//    }





}