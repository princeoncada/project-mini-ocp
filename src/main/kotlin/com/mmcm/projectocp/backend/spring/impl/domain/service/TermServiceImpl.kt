package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.TermDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.TermMapper
import com.mmcm.projectocp.backend.spring.domain.repository.TermRepository
import com.mmcm.projectocp.backend.spring.domain.service.TermService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class TermServiceImpl(
    private val termRepository: TermRepository,
    private val termMapper: TermMapper
): TermService {
    override fun getEntities(
        pageable: Pageable
    ): Page<TermDTOs.GetResult> {
        return termRepository.findAll(pageable).map { termMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<TermDTOs.GetResult> {
        val term = termRepository.findById(id, pageable)
        return term.map { termMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: TermDTOs.PostRequest,
        pageable: Pageable
    ): Page<TermDTOs.GetResult> {
        val termId = UUID.randomUUID().toString()
        val savedTerm = termRepository.save(termMapper.createEntity(termId, entityRequest))
        return termRepository.findById(savedTerm.id, pageable).map { termMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: TermDTOs.PutRequest,
        pageable: Pageable
    ): Page<TermDTOs.GetResult> {
        val term = termRepository.findById(id).get()
        val savedTerm = termRepository.save(termMapper.updateEntity(term, entityRequest))
        return termRepository.findById(savedTerm.id, pageable).map { termMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<TermDTOs.GetResult> {
        val term = termRepository.findById(id).get()
        termRepository.delete(term)
        return termRepository.findAll(pageable).map { termMapper.toGetResult(it) }
    }
}