package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.StudentCompanyAttendanceDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.StudentCompanyAttendanceMapper
import com.mmcm.projectocp.backend.spring.domain.repository.StudentCompanyAttendanceRepository
import com.mmcm.projectocp.backend.spring.domain.service.StudentCompanyAttendanceService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StudentCompanyAttendanceServiceImpl(
    private val studentCompanyAttendanceRepository: StudentCompanyAttendanceRepository,
    private val studentCompanyAttendanceMapper: StudentCompanyAttendanceMapper
): StudentCompanyAttendanceService {
    override fun getEntities(
        pageable: Pageable
    ): Page<StudentCompanyAttendanceDTOs.GetResult> {
        return studentCompanyAttendanceRepository.findAll(pageable).map { studentCompanyAttendanceMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<StudentCompanyAttendanceDTOs.GetResult> {
        val studentCompanyAttendance = studentCompanyAttendanceRepository.findById(id, pageable)
        return studentCompanyAttendance.map { studentCompanyAttendanceMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: StudentCompanyAttendanceDTOs.PostRequest,
        pageable: Pageable
    ): Page<StudentCompanyAttendanceDTOs.GetResult> {
        val studentCompanyAttendanceId = UUID.randomUUID().toString()
        val savedStudentCompanyAttendance = studentCompanyAttendanceRepository.save(studentCompanyAttendanceMapper.createEntity(studentCompanyAttendanceId, entityRequest))
        return studentCompanyAttendanceRepository.findById(savedStudentCompanyAttendance.id, pageable).map { studentCompanyAttendanceMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: StudentCompanyAttendanceDTOs.PutRequest,
        pageable: Pageable
    ): Page<StudentCompanyAttendanceDTOs.GetResult> {
        val studentCompanyAttendance = studentCompanyAttendanceRepository.findById(id).get()
        val savedStudentCompanyAttendance = studentCompanyAttendanceRepository.save(studentCompanyAttendanceMapper.updateEntity(studentCompanyAttendance, entityRequest))
        return studentCompanyAttendanceRepository.findById(savedStudentCompanyAttendance.id, pageable).map { studentCompanyAttendanceMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<StudentCompanyAttendanceDTOs.GetResult> {
        val studentCompanyAttendance = studentCompanyAttendanceRepository.findById(id).get()
        studentCompanyAttendanceRepository.delete(studentCompanyAttendance)
        return studentCompanyAttendanceRepository.findAll(pageable).map { studentCompanyAttendanceMapper.toGetResult(it) }
    }
}