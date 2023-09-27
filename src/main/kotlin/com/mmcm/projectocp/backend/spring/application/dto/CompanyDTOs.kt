package com.mmcm.projectocp.backend.spring.application.dto

class CompanyDTOs {
    data class GetResult(
        val id: String,
        val name: String,
        val companyCategory: String,
        val industryType: String,
    )

    data class PostRequest(
        val name: String,
        val companyCategory: String,
        val industryType: String,
    )

    data class PutRequest(
        val name: String?,
        val companyCategory: String?,
        val industryType: String?,
    )
}