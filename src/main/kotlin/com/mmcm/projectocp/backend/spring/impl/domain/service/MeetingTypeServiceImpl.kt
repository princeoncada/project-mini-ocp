package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MeetingTypeDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MeetingTypeMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MeetingTypeRepository
import com.mmcm.projectocp.backend.spring.domain.service.MeetingTypeService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class MeetingTypeServiceImpl(
    private val meetingTypeRepository: MeetingTypeRepository,
    private val meetingTypeMapper: MeetingTypeMapper,
): MeetingTypeService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MeetingTypeDTOs.GetResult> {
        return meetingTypeRepository.findAll(pageable).map { meetingTypeMapper.toGetResult(it)}
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MeetingTypeDTOs.GetResult> {
        val meetingType = meetingTypeRepository.findById(id, pageable)
        return meetingType.map { meetingTypeMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MeetingTypeDTOs.PostRequest,
        pageable: Pageable
    ): Page<MeetingTypeDTOs.GetResult> {
        val meetingTypeId = UUID.randomUUID().toString()
        val savedMeetingType = meetingTypeRepository.save(meetingTypeMapper.createEntity(meetingTypeId, entityRequest))
        return meetingTypeRepository.findById(savedMeetingType.id, pageable).map { meetingTypeMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MeetingTypeDTOs.PutRequest,
        pageable: Pageable
    ): Page<MeetingTypeDTOs.GetResult> {
        val currentMeetingType = meetingTypeRepository.findById(id).get()
        val savedMeetingType = meetingTypeRepository.save(meetingTypeMapper.updateEntity(currentMeetingType, entityRequest))
        return meetingTypeRepository.findById(savedMeetingType.id, pageable).map { meetingTypeMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MeetingTypeDTOs.GetResult> {
        val meetingType = meetingTypeRepository.findById(id).get()
        meetingTypeRepository.delete(meetingType)
        return meetingTypeRepository.findAll(pageable).map { meetingTypeMapper.toGetResult(it) }
    }
}