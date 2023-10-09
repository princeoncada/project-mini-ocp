package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RequirementDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.RequirementMapper
import com.mmcm.projectocp.backend.spring.domain.repository.RequirementRepository
import com.mmcm.projectocp.backend.spring.domain.service.RequirementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class RequirementServiceImpl(
    private val requirementRepository: RequirementRepository,
    private val requirementMapper: RequirementMapper
): RequirementService {
    override fun getEntities(
        pageable: Pageable
    ): Page<RequirementDTOs.GetResult> {
        return requirementRepository.findAll(pageable).map { requirementMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<RequirementDTOs.GetResult> {
        val requirement = requirementRepository.findById(id, pageable)
        return requirement.map { requirementMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: RequirementDTOs.PostRequest,
        pageable: Pageable
    ): Page<RequirementDTOs.GetResult> {
        val requirementId = UUID.randomUUID().toString()
        val savedRequirement = requirementRepository.save(requirementMapper.createEntity(requirementId, entityRequest))
        return requirementRepository.findById(savedRequirement.id, pageable).map { requirementMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: RequirementDTOs.PutRequest,
        pageable: Pageable
    ): Page<RequirementDTOs.GetResult> {
        val requirement = requirementRepository.findById(id).get()
        val savedRequirement = requirementRepository.save(requirementMapper.updateEntity(requirement, entityRequest))
        return requirementRepository.findById(savedRequirement.id, pageable).map { requirementMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<RequirementDTOs.GetResult> {
        val requirement = requirementRepository.findById(id).get()
        requirementRepository.delete(requirement)
        return requirementRepository.findAll(pageable).map { requirementMapper.toGetResult(it) }
    }
}