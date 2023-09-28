package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.LinkDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.LinkMapper
import com.mmcm.projectocp.backend.spring.domain.repository.LinkRepository
import com.mmcm.projectocp.backend.spring.domain.service.LinkService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class LinkServiceImpl(
    private val linkRepository: LinkRepository,
    private val linkMapper: LinkMapper
): LinkService {
    override fun getEntities(
        pageable: Pageable
    ): Page<LinkDTOs.GetResult> {
        return linkRepository.findAll(pageable).map { linkMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<LinkDTOs.GetResult> {
        val link = linkRepository.findById(id, pageable)
        return link.map { linkMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: LinkDTOs.PostRequest,
        pageable: Pageable
    ): Page<LinkDTOs.GetResult> {
        val linkId = UUID.randomUUID().toString()
        val savedLink = linkRepository.save(linkMapper.createEntity(linkId, entityRequest))
        return linkRepository.findById(savedLink.id, pageable).map { linkMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: LinkDTOs.PutRequest,
        pageable: Pageable
    ): Page<LinkDTOs.GetResult> {
        val currentLink = linkRepository.findById(id).get()
        val savedLink = linkRepository.save(linkMapper.updateEntity(currentLink, entityRequest))
        return linkRepository.findById(savedLink.id, pageable).map { linkMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<LinkDTOs.GetResult> {
        val link = linkRepository.findById(id).get()
        linkRepository.delete(link)
        return linkRepository.findAll(pageable).map { linkMapper.toGetResult(it) }
    }
}