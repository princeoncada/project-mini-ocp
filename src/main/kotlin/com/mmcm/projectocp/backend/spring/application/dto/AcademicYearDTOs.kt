package com.mmcm.projectocp.backend.spring.application.dto

class AcademicYearDTOs {
    data class GetResult(
        val id: String,
        val yearFrom: Int,
        val yearTo: Int
    )

    data class PostRequest(
        val yearFrom: Int,
        val yearTo: Int
    )

    data class PutRequest(
        val yearFrom: Int?,
        val yearTo: Int?
    )
}