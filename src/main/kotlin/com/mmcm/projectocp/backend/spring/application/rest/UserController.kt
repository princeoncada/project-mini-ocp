package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.UserDTO
import com.mmcm.projectocp.backend.spring.domain.model.User
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.util.*

// Todo : Implement UserController API With Auths

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get-users")
    fun getUsers(pageable: Pageable): Page<User> {
        return userRepository.findAll(pageable)
    }

    @GetMapping("/get-profile")
    fun getUserProfile(){
        TODO("Profile not yet implemented")
    }

    @GetMapping("/get-all-perms")
    fun getUserAllPerms(){
        TODO("Perms not yet implemented")
    }

    @GetMapping("/get-users", params = ["id"])
    fun getUserById(
        @RequestParam("id") userId: String
    ): User {
        return userRepository.findById(userId).orElseThrow { Exception("User not found") }
    }

    @GetMapping("/get-users", params = ["role"])
    fun getUsersByRole(){
        TODO("Not yet implemented")
    }

    @GetMapping("/get-users", params = ["student_id"])
    fun getUsersByStudentId(
        @RequestParam("student_id") studentId: String,
        pageable: Pageable
    ): Page<User> {
        return userRepository.findByStudentId(studentId, pageable)
    }

    @GetMapping("/get-users", params = ["search"])
    fun searchUsers(
        @RequestParam("search") search: String,
        pageable: Pageable
    ): Page<User> {
        return userRepository.findByEmailOrFirstNameOrLastName(search, search, search, pageable)
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/register")
    fun createUser(@RequestBody req: UserDTO): UserDTO {
        return userService.register(UserDTO(
            id = UUID.randomUUID().toString(),
            email = req.email,
            firstName = req.firstName,
            lastName = req.lastName,
            studentId = req.studentId,
            designation = req.designation
        ))
    }

}


