package com.mmcm.projectocp.backend.spring.config.service

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

@Configuration
class JwtConfiguration {
    @Bean
    fun secretKey(): SecretKey {
        val keyGenerator: KeyGenerator = KeyGenerator.getInstance("HmacSHA256")
        return keyGenerator.generateKey()
    }
}