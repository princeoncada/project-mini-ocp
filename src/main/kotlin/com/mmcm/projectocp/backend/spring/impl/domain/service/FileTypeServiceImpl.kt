package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.FileTypeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.FileTypeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.FileTypeRepository
import com.mmcm.projectocp.backend.spring.domain.service.FileTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class FileTypeServiceImpl(
    private val fileTypeRepository: FileTypeRepository,
    private val fileTypeMapper: FileTypeMapper
): FileTypeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<FileTypeDTOs.GetResult> {
        return fileTypeRepository.findAll(pageable).map { fileTypeMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<FileTypeDTOs.GetResult> {
        val fileType = fileTypeRepository.findById(id, pageable)
        return fileType.map { fileTypeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: FileTypeDTOs.PostRequest,
        pageable: Pageable
    ): Page<FileTypeDTOs.GetResult> {
        val fileTypeId = UUID.randomUUID().toString()
        val savedFileType = fileTypeRepository.save(fileTypeMapper.createEntity(fileTypeId, entityRequest))
        return fileTypeRepository.findById(savedFileType.id, pageable).map { fileTypeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: FileTypeDTOs.PutRequest,
        pageable: Pageable
    ): Page<FileTypeDTOs.GetResult> {
        val currentFileType = fileTypeRepository.findById(id).get()
        val savedFileType = fileTypeRepository.save(fileTypeMapper.updateEntity(currentFileType, entityRequest))
        return fileTypeRepository.findById(savedFileType.id, pageable).map { fileTypeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<FileTypeDTOs.GetResult> {
        val fileType = fileTypeRepository.findById(id).get()
        fileTypeRepository.delete(fileType)
        return fileTypeRepository.findAll(pageable).map { fileTypeMapper.toGetResult(it) }
    }
}