package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTO
import com.mmcm.projectocp.backend.spring.application.mapper.DepartmentMapper
import com.mmcm.projectocp.backend.spring.domain.repository.DepartmentRepository
import com.mmcm.projectocp.backend.spring.domain.service.DepartmentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/departments")
class DepartmentController (
    private val departmentService: DepartmentService,
    private val departmentRepository: DepartmentRepository,
    private val departmentMapper: DepartmentMapper
){
    @GetMapping("/get-departments")
    fun getDepartments(pageable: Pageable): Page<DepartmentDTO> {
        return departmentRepository.findAll(pageable).map { departmentMapper.toDto(it) }
    }

    @GetMapping("/get-departments", params = ["name", "abbr"])
    fun getDepartmentsByNameAndAbbr(
        name: String,
        abbr: String
    ): List<DepartmentDTO> {
        return departmentRepository.findByNameAndAbbr(name, abbr).map { departmentMapper.toDto(it) }
    }


    //Not working due to something in the model
    @PostMapping("/create-department")
    fun createDepartment(
        @RequestBody req: DepartmentDTO
    ): DepartmentDTO {
        return departmentService.createDepartment(req)
    }

//    @PutMapping("/update-department/id={id}")
//    fun updateDepartment(
//        @PathVariable id: String,
//        @RequestBody departmentRequestBody: DepartmentRequestBody): DepartmentRequestBody {
//        return departmentService.updateDepartmentById(id, departmentRequestBody)
//    }
//
//    @DeleteMapping("/delete-department/id={id}")
//    fun deleteDepartment(
//        @PathVariable id: String) {
//        departmentService.deleteDepartmentById(id)
//    }

}