package com.mmcm.projectocp.backend.spring.domain.model
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.time.LocalDate
import jakarta.persistence.*

@Entity
@Table(name = "tbl_meetings")
data class Meeting(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", length = 36, nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_branch_id", referencedColumnName = "id", nullable = false)
    val companyBranch: CompanyBranch,

    @Column(name = "title", length = 255)
    val title: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_type_id", referencedColumnName = "id", nullable = false)
    val meetingType: MeetingType,

    @Column(name = "start")
    val start: LocalDate?,

    @Column(name = "end")
    val end: LocalDate?,

    @Column(name = "description", columnDefinition = "TEXT")
    val description: String?,

    @Column(name = "minutes", columnDefinition = "TEXT")
    val minutes: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prepared_by", referencedColumnName = "id")
    val preparedBy: User?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by", referencedColumnName = "id")
    val approvedBy: User?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_status_id", referencedColumnName = "id", nullable = false)
    val meetingStatus: MeetingStatus,

    @Column(name = "meeting_link", columnDefinition = "TEXT")
    val meetingLink: String?,

    @Column(name = "recording_link", columnDefinition = "TEXT")
    val recordingLink: String?,

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    val createdAt: Instant,

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    val updatedAt: Instant
)
