package com.mmcm.projectocp.backend.spring.application.dto

class TermDTOs {
    data class GetResult(
        val id: String,
        val code: String
    )

    data class PostRequest(
        val code: String
    )

    data class PutRequest(
        val code: String
    )
}