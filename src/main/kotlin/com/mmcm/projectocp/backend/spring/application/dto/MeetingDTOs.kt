package com.mmcm.projectocp.backend.spring.application.dto

class MeetingDTOs {
    data class GetResult(
        val id: String,
        val companyBranch: String,
        val title: String?,
        val meetingType: String,
        val start: String,
        val end: String,
        val description: String?,
        val minutes: String?,
        val preparedBy: String?,
        val approvedBy: String?,
        val meetingStatus: String,
        val meetingLink: String?,
        val recordingLink: String?,
    )

    data class PostRequest(
        val companyBranch: String,
        val title: String?,
        val meetingType: String,
        val start: String,
        val end: String,
        val description: String?,
        val minutes: String?,
        val preparedBy: String?,
        val approvedBy: String?,
        val meetingStatus: String,
        val meetingLink: String?,
        val recordingLink: String?,
    )

    data class PutRequest(
        val companyBranch: String?,
        val title: String?,
        val meetingType: String?,
        val start: String?,
        val end: String?,
        val description: String?,
        val minutes: String?,
        val preparedBy: String?,
        val approvedBy: String?,
        val meetingStatus: String?,
        val meetingLink: String?,
        val recordingLink: String?,
    )
}