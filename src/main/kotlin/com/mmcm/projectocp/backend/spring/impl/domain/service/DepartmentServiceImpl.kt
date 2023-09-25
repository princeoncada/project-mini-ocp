package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.DepartmentDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.DepartmentMapper
import com.mmcm.projectocp.backend.spring.domain.repository.DepartmentRepository
import com.mmcm.projectocp.backend.spring.domain.service.DepartmentService
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class DepartmentServiceImpl(
    private val departmentRepository: DepartmentRepository,
    private val departmentMapper: DepartmentMapper
): DepartmentService {
    override fun getEntities(
        pageable: Pageable
    ): Page<DepartmentDTOs.GetResult> {
        return departmentRepository.findAll(pageable).map { departmentMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<DepartmentDTOs.GetResult> {
        val department = departmentRepository.findById(id, pageable)
        return department.map { departmentMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: DepartmentDTOs.PostRequest,
        pageable: Pageable
    ): Page<DepartmentDTOs.GetResult> {
        val departmentId = UUID.randomUUID().toString()
        val savedDepartment = departmentRepository.save(departmentMapper.createEntity(departmentId, entityRequest))
        return departmentRepository.findById(savedDepartment.id, pageable).map { departmentMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: DepartmentDTOs.PutRequest,
        pageable: Pageable
    ): Page<DepartmentDTOs.GetResult> {
        val currentDepartment = departmentRepository.findById(id).get()
        val savedDepartment = departmentRepository.save(departmentMapper.updateEntity(currentDepartment, entityRequest))
        return departmentRepository.findById(savedDepartment.id, pageable).map { departmentMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<DepartmentDTOs.GetResult> {
        val department = departmentRepository.findById(id).get()
        departmentRepository.delete(department)
        return departmentRepository.findAll(pageable).map { departmentMapper.toGetResult(it) }
    }
}