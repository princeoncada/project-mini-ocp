package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTO
import org.springframework.stereotype.Service

@Service
interface DepartmentService{
    fun createDepartment(req: DepartmentDTO): DepartmentDTO
//    fun updateDepartmentById(id: String, departmentDTO: DepartmentController.DepartmentRequestBody): Department
//    fun deleteDepartmentById(id: String)
}