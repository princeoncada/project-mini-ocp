package com.mmcm.projectocp.backend.spring.application.mapper

import com.mmcm.projectocp.backend.spring.application.dto.MeetingDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Meeting
import com.mmcm.projectocp.backend.spring.domain.repository.CompanyBranchRepository
import com.mmcm.projectocp.backend.spring.domain.repository.MeetingStatusRepository
import com.mmcm.projectocp.backend.spring.domain.repository.MeetingTypeRepository
import com.mmcm.projectocp.backend.spring.domain.repository.UserRepository
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.LocalDate

@Component
class MeetingMapper(
    private val companyBranchRepository: CompanyBranchRepository,
    private val meetingTypeRepository: MeetingTypeRepository,
    private val meetingStatusRepository: MeetingStatusRepository,
    private val userRepository: UserRepository
): EntityMapper<Meeting, MeetingDTOs.GetResult, MeetingDTOs.PostRequest, MeetingDTOs.PutRequest> {
    override fun toGetResult(
        entity: Meeting
    ): MeetingDTOs.GetResult {
        return MeetingDTOs.GetResult(
            id = entity.id,
            companyBranch = entity.companyBranch.name,
            title = entity.title,
            meetingType = entity.meetingType.name,
            start = entity.start.toString(),
            end = entity.end.toString(),
            description = entity.description,
            minutes = entity.minutes,
            preparedBy = entity.preparedBy?.email,
            approvedBy = entity.approvedBy?.email,
            meetingStatus = entity.meetingStatus.name,
            meetingLink = entity.meetingLink,
            recordingLink = entity.recordingLink,
        )
    }

    override fun createEntity(
        id: String,
        entityRequest: MeetingDTOs.PostRequest
    ): Meeting {
        return Meeting(
            id = id,
            companyBranch = companyBranchRepository.findByName(entityRequest.companyBranch).get(),
            title = entityRequest.title,
            meetingType = meetingTypeRepository.findByName(entityRequest.meetingType).get(),
            start = LocalDate.parse(entityRequest.start),
            end = LocalDate.parse(entityRequest.end),
            description = entityRequest.description,
            minutes = entityRequest.minutes,
            preparedBy = userRepository.findByEmail(entityRequest.preparedBy).get(),
            approvedBy = userRepository.findByEmail(entityRequest.approvedBy).get(),
            meetingStatus = meetingStatusRepository.findByName(entityRequest.meetingStatus).get(),
            meetingLink = entityRequest.meetingLink,
            recordingLink = entityRequest.recordingLink,
            createdAt = Instant.now(),
            updatedAt = Instant.now(),
        )
    }

    override fun updateEntity(
        entity: Meeting,
        entityRequest: MeetingDTOs.PutRequest
    ): Meeting {
        return Meeting(
            id = entity.id,
            companyBranch = companyBranchRepository.findByName(entityRequest.companyBranch ?: entity.companyBranch.name).get(),
            title = entityRequest.title ?: entity.title,
            meetingType = meetingTypeRepository.findByName(entityRequest.meetingType ?: entity.meetingType.name).get(),
            start = LocalDate.parse(entityRequest.start ?: entity.start.toString()),
            end = LocalDate.parse(entityRequest.end ?: entity.end.toString()),
            description = entityRequest.description ?: entity.description,
            minutes = entityRequest.minutes ?: entity.minutes,
            preparedBy = userRepository.findByEmail(entityRequest.preparedBy ?: entity.preparedBy?.email).get(),
            approvedBy = userRepository.findByEmail(entityRequest.approvedBy ?: entity.approvedBy?.email).get(),
            meetingStatus = meetingStatusRepository.findByName(entityRequest.meetingStatus ?: entity.meetingStatus.name).get(),
            meetingLink = entityRequest.meetingLink ?: entity.meetingLink,
            recordingLink = entityRequest.recordingLink ?: entity.recordingLink,
            createdAt = entity.createdAt,
            updatedAt = Instant.now(),
        )
    }
}