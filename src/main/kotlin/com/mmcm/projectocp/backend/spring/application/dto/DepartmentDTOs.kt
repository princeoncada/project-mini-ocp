package com.mmcm.projectocp.backend.spring.application.dto

class DepartmentDTOs {
    data class GetResult(
        val id: String,
        val name: String,
        val abbr: String
    )

    data class PostRequest(
        val name: String,
        val abbr: String
    )

    data class PutRequest(
        val name: String?,
        val abbr: String?
    )
}