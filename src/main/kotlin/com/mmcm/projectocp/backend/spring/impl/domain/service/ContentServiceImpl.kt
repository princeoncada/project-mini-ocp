package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.ContentDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.ContentMapper
import com.mmcm.projectocp.backend.spring.domain.repository.ContentRepository
import com.mmcm.projectocp.backend.spring.domain.service.ContentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ContentServiceImpl(
    private val contentRepository: ContentRepository,
    private val contentMapper: ContentMapper
): ContentService {
    override fun getEntities(
        pageable: Pageable
    ): Page<ContentDTOs.GetResult> {
        return contentRepository.findAll(pageable).map { contentMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<ContentDTOs.GetResult> {
        val content = contentRepository.findById(id, pageable)
        return content.map { contentMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: ContentDTOs.PostRequest,
        pageable: Pageable
    ): Page<ContentDTOs.GetResult> {
        val contentId = UUID.randomUUID().toString()
        val savedContent = contentRepository.save(contentMapper.createEntity(contentId, entityRequest))
        return contentRepository.findById(savedContent.id, pageable).map { contentMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: ContentDTOs.PutRequest,
        pageable: Pageable
    ): Page<ContentDTOs.GetResult> {
        val content = contentRepository.findById(id).get()
        val savedContent = contentRepository.save(contentMapper.updateEntity(content, entityRequest))
        return contentRepository.findById(savedContent.id, pageable).map { contentMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<ContentDTOs.GetResult> {
        val content = contentRepository.findById(id).get()
        contentRepository.delete(content)
        return contentRepository.findAll(pageable).map { contentMapper.toGetResult(it) }
    }
}