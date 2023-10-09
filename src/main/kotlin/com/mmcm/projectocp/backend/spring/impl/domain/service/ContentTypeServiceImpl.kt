package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.ContentTypeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.ContentTypeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.ContentTypeRepository
import com.mmcm.projectocp.backend.spring.domain.service.ContentTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class ContentTypeServiceImpl(
    private val contentTypeRepository: ContentTypeRepository,
    private val contentTypeMapper: ContentTypeMapper
): ContentTypeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<ContentTypeDTOs.GetResult> {
        return contentTypeRepository.findAll(pageable).map { contentTypeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<ContentTypeDTOs.GetResult> {
        val contentType = contentTypeRepository.findById(id, pageable)
        return contentType.map { contentTypeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: ContentTypeDTOs.PostRequest,
        pageable: Pageable
    ): Page<ContentTypeDTOs.GetResult> {
        val contentTypeId = UUID.randomUUID().toString()
        val savedContentType = contentTypeRepository.save(contentTypeMapper.createEntity(contentTypeId, entityRequest))
        return contentTypeRepository.findById(savedContentType.id, pageable).map { contentTypeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: ContentTypeDTOs.PutRequest,
        pageable: Pageable
    ): Page<ContentTypeDTOs.GetResult> {
        val contentType = contentTypeRepository.findById(id).get()
        val savedContentType = contentTypeRepository.save(contentTypeMapper.updateEntity(contentType, entityRequest))
        return contentTypeRepository.findById(savedContentType.id, pageable).map { contentTypeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<ContentTypeDTOs.GetResult> {
        val contentType = contentTypeRepository.findById(id).get()
        contentTypeRepository.delete(contentType)
        return contentTypeRepository.findAll(pageable).map { contentTypeMapper.toGetResult(it) }
    }
}