package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserDTO
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class Default (
    private val userRepository: UserRepository,
    private val userService: UserService
) {
    @GetMapping("/index")
    fun start(): String {

//        val sql = "SELECT * from tbl_users";
//        val users = jdbcTemplate.query(sql) { rs, _ ->
//            UserDTO(
//                id = rs.getNString("id"),
//                email = rs.getNString("email"),
//                firstName = rs.getNString("first_name"),
//                lastName = rs.getNString("last_name"),
//                studentId = rs.getNString("student_id"),
//                designation = rs.getNString("designation")
//            )
//        }
//
//        users.forEach { user -> println(user.toString()) }
//
//        val authentication: Authentication = SecurityContextHolder.getContext().authentication
//        return("<h2>Hello ${authentication.name}!<h2/>")

        return "index"
    }

    @GetMapping("/current-user")
    fun testPrincipal(): Authentication {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        var name: String = authentication.name.toString()
        if (authentication is OAuth2AuthenticationToken) {
            val oauth2User: OAuth2User = authentication.principal as OAuth2User
            name = oauth2User.getAttribute<String>("name").toString()
        }
        return authentication
    }

    @GetMapping("/current-user/authorities")
    fun getAuthorities(authentication: Authentication): List<String> {
        val authorities: MutableCollection<out GrantedAuthority> = authentication.authorities
        return authorities.map { it.authority }
    }

    @GetMapping("/register-current-user")
    fun testRegister(): String {

        val authentication: Authentication = SecurityContextHolder.getContext().authentication

        if (authentication is OAuth2AuthenticationToken) {
            val oauth2User: OAuth2User = authentication.principal as OAuth2User
            val email: String = oauth2User.getAttribute<String>("email").toString()
            if(!(userRepository.existsByEmail(email))){
                userService.register(
                    UserDTO(
                        id = UUID.randomUUID().toString(),
                        email = oauth2User.getAttribute<String>("email").toString(),
                        firstName = oauth2User.getAttribute<String>("given_name").toString(),
                        lastName = oauth2User.getAttribute<String>("family_name").toString(),
                        studentId = UUID.randomUUID().toString(),
                        designation = "CS"
                    )
                )
            }
        }

        return "registered"
    }

//    @GetMapping("/test")
//    fun testQuery() {
//        val sql = "SELECT * from tbl_users WHERE email = 'mrlotzo@gmail.com'"
//        val userQuery = jdbcTemplate.query(sql) { rs, _ ->
//            UserDTO(
//                id = rs.getNString("id"),
//                email = rs.getNString("email"),
//                firstName = rs.getNString("first_name"),
//                lastName = rs.getNString("last_name"),
//                studentId = rs.getNString("student_id"),
//                designation = rs.getNString("designation")
//            )
//        }
//
//    }

}