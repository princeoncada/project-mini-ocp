package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.StudentTestimonyDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.StudentTestimonyMapper
import com.mmcm.projectocp.backend.spring.domain.repository.StudentTestimonyRepository
import com.mmcm.projectocp.backend.spring.domain.service.StudentTestimonyService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class StudentTestimonyServiceImpl(
    private val studentTestimonyRepository: StudentTestimonyRepository,
    private val studentTestimonyMapper: StudentTestimonyMapper
): StudentTestimonyService {
    override fun getEntities(
        pageable: Pageable
    ): Page<StudentTestimonyDTOs.GetResult> {
        return studentTestimonyRepository.findAll(pageable).map { studentTestimonyMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<StudentTestimonyDTOs.GetResult> {
        val studentTestimony = studentTestimonyRepository.findById(id, pageable)
        return studentTestimony.map { studentTestimonyMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: StudentTestimonyDTOs.PostRequest,
        pageable: Pageable
    ): Page<StudentTestimonyDTOs.GetResult> {
        val studentTestimonyId = UUID.randomUUID().toString()
        val savedStudentTestimony = studentTestimonyRepository.save(studentTestimonyMapper.createEntity(studentTestimonyId, entityRequest))
        return studentTestimonyRepository.findById(savedStudentTestimony.id, pageable).map { studentTestimonyMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: StudentTestimonyDTOs.PutRequest,
        pageable: Pageable
    ): Page<StudentTestimonyDTOs.GetResult> {
        val studentTestimony = studentTestimonyRepository.findById(id).get()
        val savedStudentTestimony = studentTestimonyRepository.save(studentTestimonyMapper.updateEntity(studentTestimony, entityRequest))
        return studentTestimonyRepository.findById(savedStudentTestimony.id, pageable).map { studentTestimonyMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<StudentTestimonyDTOs.GetResult> {
        val studentTestimony = studentTestimonyRepository.findById(id).get()
        studentTestimonyRepository.delete(studentTestimony)
        return studentTestimonyRepository.findAll(pageable).map { studentTestimonyMapper.toGetResult(it) }
    }
}