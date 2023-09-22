package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTO
import com.mmcm.projectocp.backend.spring.application.mapper.DepartmentMapper
import com.mmcm.projectocp.backend.spring.domain.repository.DepartmentRepository
import com.mmcm.projectocp.backend.spring.domain.service.DepartmentService
import org.springframework.stereotype.Service

@Service
class DepartmentServiceImpl(
    private val departmentRepository: DepartmentRepository,
    private val departmentMapper: DepartmentMapper

) : DepartmentService {

    override fun createDepartment(req: DepartmentDTO): DepartmentDTO {
        val department = departmentMapper.toEntity(req)
        val departmentDTO = departmentRepository.save(department)
        return departmentMapper.toDto(departmentDTO)
    }



//    override fun updateDepartmentById(
//        id: String,
//        departmentDTO: DepartmentController.DepartmentRequestBody
//    ):  DepartmentController.DepartmentRequestBody {
//        TODO("Not yet implemented")
//    }
//
//    override fun deleteDepartmentById(id: String) {
//        TODO("Not yet implemented")
//    }

}