package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.FileDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.FileMapper
import com.mmcm.projectocp.backend.spring.domain.repository.FileRepository
import com.mmcm.projectocp.backend.spring.domain.service.FileService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class FileServiceImpl(
    private val fileRepository: FileRepository,
    private val fileMapper: FileMapper
): FileService {
    override fun getEntities(
        pageable: Pageable
    ): Page<FileDTOs.GetResult> {
        return fileRepository.findAll(pageable).map { fileMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<FileDTOs.GetResult> {
        val file = fileRepository.findById(id, pageable)
        return file.map { fileMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: FileDTOs.PostRequest,
        pageable: Pageable
    ): Page<FileDTOs.GetResult> {
        val fileId = UUID.randomUUID().toString()
        val savedFile = fileRepository.save(fileMapper.createEntity(fileId, entityRequest))
        return fileRepository.findById(savedFile.id, pageable).map { fileMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: FileDTOs.PutRequest,
        pageable: Pageable
    ): Page<FileDTOs.GetResult> {
        val file = fileRepository.findById(id).get()
        val savedFile = fileRepository.save(fileMapper.updateEntity(file, entityRequest))
        return fileRepository.findById(savedFile.id, pageable).map { fileMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<FileDTOs.GetResult> {
        val file = fileRepository.findById(id).get()
        fileRepository.delete(file)
        return fileRepository.findAll(pageable).map { fileMapper.toGetResult(it) }
    }
}