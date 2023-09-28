package com.mmcm.projectocp.backend.spring.application.dto

class MoaPositionDTOs {
    data class GetResult(
        val id: String,
        val moa: String?,
        val yearTo: Int?,
        val yearFrom: Int?,
        val name: String,
        val requirements: String?,
        val studentsAccommodated: Int?,
    )

    data class PostRequest(
        val moa: String,
        val yearTo: Int,
        val yearFrom: Int,
        val name: String,
        val requirements: String?,
        val studentsAccommodated: Int?,
    )

    data class PutRequest(
        val moa: String?,
        val yearTo: Int,
        val yearFrom: Int,
        val name: String?,
        val requirements: String?,
        val studentsAccommodated: Int?,
    )
}