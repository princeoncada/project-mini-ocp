package com.mmcm.projectocp.backend.spring.application.dto

class CompanyBranchDTOs {
    data class GetResult(
        val id: String,
        val name: String,
        val company: String,
        val country: String,
        val address: String?,
        val zipCode: String?,
        val isMainBranch: Boolean?,
        val phone: String?,
        val email: String?,
        val description: String?,
        val region: String?,
        val province: String?,
        val cityMunicipality: String?,
        val barangay: String?,
    )

    data class PostRequest(
        val name: String,
        val company: String,
        val country: String,
        val address: String?,
        val zipCode: String?,
        val isMainBranch: Boolean?,
        val phone: String?,
        val email: String?,
        val description: String?,
        val region: String?,
        val province: String?,
        val cityMunicipality: String?,
        val barangay: String?,
    )

    data class PutRequest(
        val name: String?,
        val company: String?,
        val country: String?,
        val address: String?,
        val zipCode: String?,
        val isMainBranch: Boolean?,
        val phone: String?,
        val email: String?,
        val description: String?,
        val region: String?,
        val province: String?,
        val cityMunicipality: String?,
        val barangay: String?,
    )
}