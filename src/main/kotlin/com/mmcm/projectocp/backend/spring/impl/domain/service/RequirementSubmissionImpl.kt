package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RequirementSubmissionDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.RequirementSubmissionMapper
import com.mmcm.projectocp.backend.spring.domain.repository.RequirementSubmissionRepository
import com.mmcm.projectocp.backend.spring.domain.service.RequirementSubmissionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class RequirementSubmissionImpl(
    private val requirementSubmissionRepository: RequirementSubmissionRepository,
    private val requirementSubmissionMapper: RequirementSubmissionMapper
): RequirementSubmissionService {
    override fun getEntities(
        pageable: Pageable
    ): Page<RequirementSubmissionDTOs.GetResult> {
        return requirementSubmissionRepository.findAll(pageable).map { requirementSubmissionMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<RequirementSubmissionDTOs.GetResult> {
        val requirementSubmission = requirementSubmissionRepository.findById(id, pageable)
        return requirementSubmission.map { requirementSubmissionMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: RequirementSubmissionDTOs.PostRequest,
        pageable: Pageable
    ): Page<RequirementSubmissionDTOs.GetResult> {
        val requirementSubmissionId = UUID.randomUUID().toString()
        val savedRequirementSubmission = requirementSubmissionRepository.save(requirementSubmissionMapper.createEntity(requirementSubmissionId, entityRequest))
        return requirementSubmissionRepository.findById(savedRequirementSubmission.id, pageable).map { requirementSubmissionMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: RequirementSubmissionDTOs.PutRequest,
        pageable: Pageable
    ): Page<RequirementSubmissionDTOs.GetResult> {
        val requirementSubmission = requirementSubmissionRepository.findById(id).get()
        val savedRequirementSubmission = requirementSubmissionRepository.save(requirementSubmissionMapper.updateEntity(requirementSubmission, entityRequest))
        return requirementSubmissionRepository.findById(savedRequirementSubmission.id, pageable).map { requirementSubmissionMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<RequirementSubmissionDTOs.GetResult> {
        val requirementSubmission = requirementSubmissionRepository.findById(id).get()
        requirementSubmissionRepository.delete(requirementSubmission)
        return requirementSubmissionRepository.findAll(pageable).map { requirementSubmissionMapper.toGetResult(it) }
    }
}