package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MeetingStatusDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MeetingStatusMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MeetingStatusRepository
import com.mmcm.projectocp.backend.spring.domain.service.MeetingStatusService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class MeetingStatusServiceImpl(
    private val meetingStatusRepository: MeetingStatusRepository,
    private val meetingStatusMapper: MeetingStatusMapper
) : MeetingStatusService {
    override fun getEntities(pageable: Pageable): Page<MeetingStatusDTOs.GetResult> {
        return meetingStatusRepository.findAll(pageable).map { meetingStatusMapper.toGetResult(it) }
    }

    override fun getEntityById(id: String, pageable: Pageable): Page<MeetingStatusDTOs.GetResult> {
        return meetingStatusRepository.findById(id, pageable).map { meetingStatusMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MeetingStatusDTOs.PostRequest,
        pageable: Pageable
    ): Page<MeetingStatusDTOs.GetResult> {
        val meetingStatusId = UUID.randomUUID().toString()
        val savedMeetingStatus = meetingStatusRepository.save(meetingStatusMapper.createEntity(meetingStatusId, entityRequest))
        return meetingStatusRepository.findById(savedMeetingStatus.id, pageable).map { meetingStatusMapper.toGetResult(it) }

    }

    override fun updateEntityById(
        id: String,
        entityRequest: MeetingStatusDTOs.PutRequest,
        pageable: Pageable
    ): Page<MeetingStatusDTOs.GetResult> {
        val currentMeetingStatus = meetingStatusRepository.findById(id).get()
        meetingStatusRepository.save(meetingStatusMapper.updateEntity(currentMeetingStatus, entityRequest))
        return meetingStatusRepository.findById(id, pageable).map { meetingStatusMapper.toGetResult(it) }
    }

    override fun deleteEntityById(id: String, pageable: Pageable): Page<MeetingStatusDTOs.GetResult> {
        val meetingStatus = meetingStatusRepository.findById(id).get()
        meetingStatusRepository.delete(meetingStatus)
        return meetingStatusRepository.findAll(pageable).map { meetingStatusMapper.toGetResult(it) }
    }


}