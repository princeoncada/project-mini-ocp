package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.IndustryTypeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.IndustryTypeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.IndustryTypeRepository
import com.mmcm.projectocp.backend.spring.domain.service.IndustryTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class IndustryTypeServiceImpl(
    private val industryTypeRepository: IndustryTypeRepository,
    private val industryTypeMapper: IndustryTypeMapper
) : IndustryTypeService {
    override fun getEntities(pageable: Pageable): Page<IndustryTypeDTOs.GetResult> {
        return industryTypeRepository.findAll(pageable).map { industryTypeMapper.toGetResult(it) }
    }

    override fun getEntityById(id: String, pageable: Pageable): Page<IndustryTypeDTOs.GetResult> {
        val industryType = industryTypeRepository.findById(id, pageable)
        return industryType.map { industryTypeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: IndustryTypeDTOs.PostRequest,
        pageable: Pageable
    ): Page<IndustryTypeDTOs.GetResult> {
        val industryTypeId = UUID.randomUUID().toString()
        val savedIndustryType = industryTypeRepository.save(industryTypeMapper.createEntity(industryTypeId, entityRequest))
        return industryTypeRepository.findById(savedIndustryType.id, pageable).map { industryTypeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: IndustryTypeDTOs.PutRequest,
        pageable: Pageable
    ): Page<IndustryTypeDTOs.GetResult> {
        val currentIndustryType = industryTypeRepository.findById(id).get()
        industryTypeRepository.save(industryTypeMapper.updateEntity(currentIndustryType, entityRequest))
        return industryTypeRepository.findById(id, pageable).map { industryTypeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(id: String, pageable: Pageable): Page<IndustryTypeDTOs.GetResult> {
        val industryType = industryTypeRepository.findById(id).get()
        industryTypeRepository.delete(industryType)
        return industryTypeRepository.findAll(pageable).map { industryTypeMapper.toGetResult(it) }
    }
}