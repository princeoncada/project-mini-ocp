package com.mmcm.projectocp.backend.spring.application.dto

class StudentCompanyAttendanceDTOs {
    data class GetResult(
        val id: String,
        val studentCourse: String,
        val moa: String?,
        val designation: String,
        val hours: Int,
        val dateStart: String,
        val dateEnd: String?,
        val finishedAt: String?,
        val cancelledAt: String?
    )

    data class PostRequest(
        val studentCourse: String,
        val moa: String,
        val designation: String,
        val hours: Int,
        val dateStart: String,
        val dateEnd: String?,
        val finishedAt: String?,
        val cancelledAt: String?
    )

    data class PutRequest(
        val studentCourse: String?,
        val moa: String?,
        val designation: String?,
        val hours: Int?,
        val dateStart: String?,
        val dateEnd: String?,
        val finishedAt: String?,
        val cancelledAt: String?
    )
}