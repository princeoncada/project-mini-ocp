package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.LinkDTOs

interface LinkService: EntityService<LinkDTOs.GetResult, LinkDTOs.PostRequest, LinkDTOs.PutRequest> {
}