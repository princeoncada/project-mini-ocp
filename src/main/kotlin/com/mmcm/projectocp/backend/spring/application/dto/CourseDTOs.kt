package com.mmcm.projectocp.backend.spring.application.dto

class CourseDTOs {
    data class GetResult(
        val id: String,
        val yearTo: Int,
        val yearFrom: Int,
        val term: String,
        val name: String,
        val code: String,
        val instructor: String?,
        val isActive: Boolean
    )

    data class PostRequest(
        val yearTo: Int,
        val yearFrom: Int,
        val term: String,
        val name: String,
        val code: String,
        val instructor: String?,
        val isActive: Boolean
    )

    data class PutRequest(
        val yearTo: Int,
        val yearFrom: Int,
        val term: String?,
        val name: String?,
        val code: String?,
        val instructor: String?,
        val isActive: Boolean?
    )
}