package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Role
import com.mmcm.projectocp.backend.spring.domain.model.User
import com.mmcm.projectocp.backend.spring.domain.model.UserRole
import com.mmcm.projectocp.backend.spring.domain.repository.RoleRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRoleRepository
import com.mmcm.projectocp.backend.spring.domain.service.AuthorityModificationService
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.data.domain.Pageable
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.time.Instant
import java.util.UUID

@RestController
class AuthController (
    private val authorityModificationService: AuthorityModificationService,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val userRoleRepository: UserRoleRepository,
    private val userService: UserService
) {

    lateinit var authentication: Authentication

    @GetMapping("/")
    fun start(pageable: Pageable): ModelAndView {

        authentication = SecurityContextHolder.getContext().authentication
        if (authentication is OAuth2AuthenticationToken) {
            val oauth2User: OAuth2User = authentication.principal as OAuth2User
            val email: String = oauth2User.getAttribute<String>("email").toString()
            if(!(userRepository.existsByEmail(email))){
                userService.createEntity(
                    UserDTOs.PostRequest(
                        email = email,
                        firstName = oauth2User.getAttribute<String>("given_name").toString(),
                        lastName = oauth2User.getAttribute<String>("family_name").toString(),
                        studentId = UUID.randomUUID().toString(),
                        designation = "CS"
                    ),
                    pageable
                )
                println("Successfully Registered!")

                val user: User = userRepository.findByEmail(email).get()
                val role: Role = roleRepository.findByName("student").get()
                userRoleRepository.save(
                    UserRole(
                        id = UUID.randomUUID().toString(),
                        user = user,
                        role = role,
                        createdAt = Instant.now(),
                        updatedAt = Instant.now()
                    )
                )
                println("Successfully assigned Student Role!")
            }
        }

        authorityModificationService.modifyAuthorities(authentication)
        return ModelAndView("index")
    }

    @GetMapping("/current-user")
    fun testPrincipal(): Authentication {
        authentication = SecurityContextHolder.getContext().authentication
        return authentication
    }

    @GetMapping("/current-user/email")
    fun getEmail(): String {
        authentication = SecurityContextHolder.getContext().authentication
        var email: String = authentication.name.toString()
        if (authentication is OAuth2AuthenticationToken) {
            val oauth2User: OAuth2User = authentication.principal as OAuth2User
            email = oauth2User.getAttribute<String>("email").toString()
        }
        return email
    }

    @GetMapping("/current-user/authorities")
    fun getAuthorities(authentication: Authentication): List<String> {
        val authorities: MutableCollection<out GrantedAuthority> = authentication.authorities
        return authorities.map { it.authority }
    }

    @GetMapping("/current-user/authorities/is-admin")
    fun getAuthoritiesAndAdmin(): List<String> {
        authentication = SecurityContextHolder.getContext().authentication

        val newAuthorities = mutableListOf<GrantedAuthority>()
        authentication.authorities.forEach { presentAuthority ->
            newAuthorities.add(presentAuthority)
        }

        if (!newAuthorities.any { it.authority == "admin" }) {
            newAuthorities.add(GrantedAuthority { "admin" })
        }else {
            println("Admin already an Authority!")
        }

        val newAuth = UsernamePasswordAuthenticationToken(
                authentication.principal,
                authentication.credentials,
                newAuthorities
        )

        SecurityContextHolder.getContext().authentication = newAuth
        return authentication.authorities.map { it.authority }
    }

    @GetMapping("/current-user/add-admin")
    fun setAuthority(): String {
        val admin = "admin"
        authentication = SecurityContextHolder.getContext().authentication
        val newAuthorities = mutableListOf<GrantedAuthority>()
        newAuthorities.add(GrantedAuthority { admin })
        authentication.authorities.forEach { presentAuthority ->
            newAuthorities.add(presentAuthority)
        }

        val newAuth = UsernamePasswordAuthenticationToken(
                authentication.principal,
                authentication.credentials,
                newAuthorities
        )

        SecurityContextHolder.getContext().authentication = newAuth
        return "Successfully added admin Auth"
    }

    @GetMapping("/current-user/admin")
    fun isAdmin(): String {
        val authentication: Authentication = SecurityContextHolder.getContext().authentication
        val oauth2User: OAuth2User = authentication.principal as OAuth2User
        val email: String = oauth2User.getAttribute<String>("email").toString()
        val userId: String = userRepository.findByEmail(email).get().id
        val userHasRole: Boolean = userRoleRepository.existsByUserId(userId)
        if(userHasRole) {
            val userRole: UserRole = userRoleRepository.findByUserId(userId)
            if(userRole.role.name == "admin"){
                return "$email is an admin"
            }
        }
        return "$email is not an admin"
    }

}