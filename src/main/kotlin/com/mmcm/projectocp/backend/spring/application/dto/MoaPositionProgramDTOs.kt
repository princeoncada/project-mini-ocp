package com.mmcm.projectocp.backend.spring.application.dto

class MoaPositionProgramDTOs {
    data class GetResult(
        val id: String,
        val program: String,
        val moaPosition: String,
        val studentsAccommodated: Int?
    )

    data class PostRequest(
        val program: String,
        val moaPosition: String,
        val studentsAccommodated: Int?
    )

    data class PutRequest(
        val program: String?,
        val moaPosition: String?,
        val studentsAccommodated: Int?
    )
}