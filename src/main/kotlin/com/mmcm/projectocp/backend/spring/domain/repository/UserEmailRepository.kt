package com.mmcm.projectocp.backend.spring.domain.repository

import com.mmcm.projectocp.backend.spring.domain.model.UserEmail
import org.springframework.data.jpa.repository.JpaRepository

interface UserEmailRepository : JpaRepository<UserEmail, String> {
    // You can add custom query methods here if needed
}
