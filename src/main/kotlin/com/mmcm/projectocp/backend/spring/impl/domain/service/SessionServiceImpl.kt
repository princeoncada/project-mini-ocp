package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.SessionDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.SessionMapper
import com.mmcm.projectocp.backend.spring.domain.repository.SessionRepository
import com.mmcm.projectocp.backend.spring.domain.service.SessionService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SessionServiceImpl(
    private val sessionRepository: SessionRepository,
    private val sessionMapper: SessionMapper
): SessionService {
    override fun getEntities(
        pageable: Pageable
    ): Page<SessionDTOs.GetResult> {
        return sessionRepository.findAll(pageable).map { sessionMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<SessionDTOs.GetResult> {
        val session = sessionRepository.findById(id, pageable)
        return session.map { sessionMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: SessionDTOs.PostRequest,
        pageable: Pageable
    ): Page<SessionDTOs.GetResult> {
        val sessionId = UUID.randomUUID().toString()
        val savedSession = sessionRepository.save(sessionMapper.createEntity(sessionId, entityRequest))
        return sessionRepository.findById(savedSession.id, pageable).map { sessionMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: SessionDTOs.PutRequest,
        pageable: Pageable
    ): Page<SessionDTOs.GetResult> {
        val session = sessionRepository.findById(id).get()
        val savedSession = sessionRepository.save(sessionMapper.updateEntity(session, entityRequest))
        return sessionRepository.findById(savedSession.id, pageable).map { sessionMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<SessionDTOs.GetResult> {
        val session = sessionRepository.findById(id).get()
        sessionRepository.delete(session)
        return sessionRepository.findAll(pageable).map { sessionMapper.toGetResult(it) }
    }
}