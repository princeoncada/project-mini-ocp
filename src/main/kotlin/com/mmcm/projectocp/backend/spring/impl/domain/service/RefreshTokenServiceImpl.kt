package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RefreshTokenDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.RefreshTokenMapper
import com.mmcm.projectocp.backend.spring.domain.repository.RefreshTokenRepository
import com.mmcm.projectocp.backend.spring.domain.service.RefreshTokenService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class RefreshTokenServiceImpl(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val refreshTokenMapper: RefreshTokenMapper
): RefreshTokenService {
    override fun getEntities(
        pageable: Pageable
    ): Page<RefreshTokenDTOs.GetResult> {
        return refreshTokenRepository.findAll(pageable).map { refreshTokenMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<RefreshTokenDTOs.GetResult> {
        val refreshToken = refreshTokenRepository.findById(id, pageable)
        return refreshToken.map { refreshTokenMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: RefreshTokenDTOs.PostRequest,
        pageable: Pageable
    ): Page<RefreshTokenDTOs.GetResult> {
        val refreshTokenId = UUID.randomUUID().toString()
        val savedRefreshToken = refreshTokenRepository.save(refreshTokenMapper.createEntity(refreshTokenId, entityRequest))
        return refreshTokenRepository.findById(savedRefreshToken.id, pageable).map { refreshTokenMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<RefreshTokenDTOs.GetResult> {
        val refreshToken = refreshTokenRepository.findById(id).get()
        refreshTokenRepository.delete(refreshToken)
        return refreshTokenRepository.findAll(pageable).map { refreshTokenMapper.toGetResult(it) }
    }
}