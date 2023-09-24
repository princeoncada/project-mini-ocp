package com.mmcm.projectocp.backend.spring.application.dto

class MeetingTypeDTOs {
    data class GetResult(
        val id: String,
        val name: String,
        val meetingMode: String,
    )

    data class PostRequest(
        val name: String,
        val meetingMode: String,
    )

    data class PutRequest(
        val name: String?,
        val meetingMode: String?,
    )
}