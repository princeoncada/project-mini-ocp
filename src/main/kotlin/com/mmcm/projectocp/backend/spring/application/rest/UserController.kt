package com.mmcm.projectocp.backend.spring.application.rest


import com.mmcm.projectocp.backend.spring.domain.model.UserEntity
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.security.Principal

// Todo : Implement UserController API With Auths

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService,
    private val userRepository: UserRepository,

) {

    @GetMapping("/get-auth/admin")
    fun getAuthAdmin(
        principal: Principal?
    ): String {
        return if (principal != null) {
            principal.name
        } else {
            "No Auth from admin"
        }
    }


    @GetMapping("/get-auth/student")

    fun getAuth(
        principal: Principal?
    ): String {
        return if (principal != null) {
            principal.name
        } else {
            "No Auth frp, student"
        }
    }

    @GetMapping("/get-users")
    fun getUsers(
        pageable: Pageable
    ): Page<UserEntity> {
        return userRepository.findAll(pageable)
    }

    @GetMapping("/get-profile")
    fun getUserProfile() {
        TODO("Profile not yet implemented")
    }

    @GetMapping("/get-all-perms")
    fun getUserAllPerms() {
        TODO("Perms not yet implemented")
    }

    @GetMapping("/get-users", params = ["id"])
    fun getUserById(
        @RequestParam("id") userId: String
    ): UserEntity {
        return userRepository.findById(userId).orElseThrow { Exception("User not found") }
    }

    @GetMapping("/get-users", params = ["role"])
    fun getUsersByRole(
        @RequestParam("role") role: String,
        pageable: Pageable
    ): Page<UserEntity> {
        return userRepository.findUsersByRolesName(role, pageable)
    }


    @GetMapping("/get-users", params = ["student_id"])
    fun getUsersByStudentId(
        @RequestParam("student_id") studentId: String,
        pageable: Pageable
    ): Page<UserEntity> {
        return userRepository.findByStudentId(studentId, pageable)
    }

    @GetMapping("/get-users", params = ["search"])
    fun getUsersBySearch(
        @RequestParam("search") search: String,
        pageable: Pageable
    ): Page<UserEntity> {
        return userRepository.findByEmailOrFirstNameOrLastName(search, search, search, pageable)
    }

}


