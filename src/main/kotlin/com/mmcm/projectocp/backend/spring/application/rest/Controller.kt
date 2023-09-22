package com.mmcm.projectocp.backend.spring.application.rest

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface Controller<GetResult, PostResult, PutResult> {
    fun getEntities(
        pageable: Pageable
    ): ResponseEntity<Page<GetResult>>

    fun getEntityById(
        id: String,
        pageable: Pageable
    ): ResponseEntity<Page<GetResult>>

    fun createEntity(
        entityRequest: PostResult,
        pageable: Pageable
    ): ResponseEntity<Page<GetResult>>

    fun updateEntityById(
        id: String,
        entityRequest: PutResult,
        pageable: Pageable
    ): ResponseEntity<Page<GetResult>>

    fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): ResponseEntity<Page<GetResult>>
}