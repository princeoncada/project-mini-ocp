package com.mmcm.projectocp.backend.spring.impl.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.MeetingDTOs
import com.mmcm.projectocp.backend.spring.application.mapper.MeetingMapper
import com.mmcm.projectocp.backend.spring.domain.repository.MeetingRepository
import com.mmcm.projectocp.backend.spring.domain.service.MeetingService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MeetingServiceImpl(
    private val meetingRepository: MeetingRepository,
    private val meetingMapper: MeetingMapper
): MeetingService {
    override fun getEntities(
        pageable: Pageable
    ): Page<MeetingDTOs.GetResult> {
        return meetingRepository.findAll(pageable).map { meetingMapper.toGetResult(it) }
    }

    override fun getEntityById(
        id: String,
        pageable: Pageable
    ): Page<MeetingDTOs.GetResult> {
        val meeting = meetingRepository.findById(id, pageable)
        return meeting.map { meetingMapper.toGetResult(it) }
    }

    override fun createEntity(
        entityRequest: MeetingDTOs.PostRequest,
        pageable: Pageable
    ): Page<MeetingDTOs.GetResult> {
        val meetingId = UUID.randomUUID().toString()
        val savedMeeting = meetingRepository.save(meetingMapper.createEntity(meetingId, entityRequest))
        return meetingRepository.findById(savedMeeting.id, pageable).map { meetingMapper.toGetResult(it) }
    }

    override fun updateEntityById(
        id: String,
        entityRequest: MeetingDTOs.PutRequest,
        pageable: Pageable
    ): Page<MeetingDTOs.GetResult> {
        val meeting = meetingRepository.findById(id).get()
        val savedMeeting = meetingRepository.save(meetingMapper.updateEntity(meeting, entityRequest))
        return meetingRepository.findById(savedMeeting.id, pageable).map { meetingMapper.toGetResult(it) }
    }

    override fun deleteEntityById(
        id: String,
        pageable: Pageable
    ): Page<MeetingDTOs.GetResult> {
        val meeting = meetingRepository.findById(id).get()
        meetingRepository.delete(meeting)
        return meetingRepository.findAll(pageable).map { meetingMapper.toGetResult(it) }
    }
}