package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MoaDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MoaMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MoaRepository
import com.mmcm.projectocp.backend.spring.domain.service.MoaService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class MoaServiceImpl(
    private val moaRepository: MoaRepository,
    private val moaMapper: MoaMapper
): MoaService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MoaDTOs.GetResult> {
        return moaRepository.findAll(pageable).map { moaMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaDTOs.GetResult> {
        val moa = moaRepository.findById(id, pageable)
        return moa.map { moaMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MoaDTOs.PostRequest,
        pageable: Pageable
    ): Page<MoaDTOs.GetResult> {
        val moaId = UUID.randomUUID().toString()
        val savedMoa = moaRepository.save(moaMapper.createEntity(moaId, entityRequest))
        return moaRepository.findById(savedMoa.id, pageable).map { moaMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MoaDTOs.PutRequest,
        pageable: Pageable
    ): Page<MoaDTOs.GetResult> {
        val moa = moaRepository.findById(id).get()
        val savedMoa = moaRepository.save(moaMapper.updateEntity(moa, entityRequest))
        return moaRepository.findById(savedMoa.id, pageable).map { moaMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MoaDTOs.GetResult> {
        val moa = moaRepository.findById(id).get()
        moaRepository.delete(moa)
        return moaRepository.findAll(pageable).map { moaMapper.toGetResult(it) }
    }
}