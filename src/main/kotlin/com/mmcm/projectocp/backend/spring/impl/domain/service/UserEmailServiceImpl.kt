package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.UserEmailDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.UserEmailMapper
import com.mmcm.projectocp.backend.spring.domain.repository.UserEmailRepository
import com.mmcm.projectocp.backend.spring.domain.service.UserEmailService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserEmailServiceImpl(
    private val userEmailRepository: UserEmailRepository,
    private val userEmailMapper: UserEmailMapper
): UserEmailService {
    override fun getEntities(
        pageable: Pageable
    ): Page<UserEmailDTOs.GetResult> {
        return userEmailRepository.findAll(pageable).map { userEmailMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<UserEmailDTOs.GetResult> {
        val userEmail = userEmailRepository.findById(id, pageable)
        return userEmail.map { userEmailMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: UserEmailDTOs.PostRequest,
        pageable: Pageable
    ): Page<UserEmailDTOs.GetResult> {
        val userEmailId = UUID.randomUUID().toString()
        val savedUserEmail = userEmailRepository.save(userEmailMapper.createEntity(userEmailId, entityRequest))
        return userEmailRepository.findById(savedUserEmail.id, pageable).map { userEmailMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: UserEmailDTOs.PutRequest,
        pageable: Pageable
    ): Page<UserEmailDTOs.GetResult> {
        val userEmail = userEmailRepository.findById(id).get()
        val savedUserEmail = userEmailRepository.save(userEmailMapper.updateEntity(userEmail, entityRequest))
        return userEmailRepository.findById(savedUserEmail.id, pageable).map { userEmailMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<UserEmailDTOs.GetResult> {
        val userEmail = userEmailRepository.findById(id).get()
        userEmailRepository.delete(userEmail)
        return userEmailRepository.findAll(pageable).map { userEmailMapper.toGetResult(it) }
    }
}