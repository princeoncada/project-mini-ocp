package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.LinkTypeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.LinkTypeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.LinkTypeRepository
import com.mmcm.projectocp.backend.spring.domain.service.LinkTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class LinkTypeServiceImpl(
    private val linkTypeRepository: LinkTypeRepository,
    private val linkTypeMapper: LinkTypeMapper
): LinkTypeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<LinkTypeDTOs.GetResult> {
        return linkTypeRepository.findAll(pageable).map { linkTypeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<LinkTypeDTOs.GetResult> {
        val linkType = linkTypeRepository.findById(id, pageable)
        return linkType.map { linkTypeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: LinkTypeDTOs.PostRequest,
        pageable: Pageable
    ): Page<LinkTypeDTOs.GetResult> {
        val linkTypeId = UUID.randomUUID().toString()
        val savedLinkType = linkTypeRepository.save(linkTypeMapper.createEntity(linkTypeId, entityRequest))
        return linkTypeRepository.findById(savedLinkType.id, pageable).map { linkTypeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: LinkTypeDTOs.PutRequest,
        pageable: Pageable
    ): Page<LinkTypeDTOs.GetResult> {
        val linkType = linkTypeRepository.findById(id).get()
        val savedLinkType = linkTypeRepository.save(linkTypeMapper.updateEntity(linkType, entityRequest))
        return linkTypeRepository.findById(savedLinkType.id, pageable).map { linkTypeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<LinkTypeDTOs.GetResult> {
        val linkType = linkTypeRepository.findById(id).get()
        linkTypeRepository.delete(linkType)
        return linkTypeRepository.findAll(pageable).map { linkTypeMapper.toGetResult(it) }
    }
}