package com.mmcm.projectocp.backend.spring.application.dto

class CompanyContactPersonDTOs {
    data class GetResult(
        val id: String,
        val company: String,
        val name: String,
        val designation: String?,
        val email: String?,
        val phone: String?,
        val isActive: Boolean,
        val createdAt: String,
        val updatedAt: String
    )

    data class PostRequest(
        val company: String,
        val name: String,
        val designation: String?,
        val email: String?,
        val phone: String?,
        val isActive: Boolean
    )

    data class PutRequest(
        val company: String?,
        val name: String?,
        val designation: String?,
        val email: String?,
        val phone: String?,
        val isActive: Boolean?
    )
}