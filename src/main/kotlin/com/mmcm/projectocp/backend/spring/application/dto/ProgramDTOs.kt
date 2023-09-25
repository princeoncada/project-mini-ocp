package com.mmcm.projectocp.backend.spring.application.dto

import com.mmcm.projectocp.backend.spring.domain.model.Department

class ProgramDTOs {
    data class GetResult(
        val id: String,
        val department: String,
        val name: String,
        val abbr: String
    )

    data class PostRequest(
        val department: String,
        val name: String,
        val abbr: String,
    )

    data class PutRequest(
        val department: String?,
        val name: String?,
        val abbr: String?,
    )
}