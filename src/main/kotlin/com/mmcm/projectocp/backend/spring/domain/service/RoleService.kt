package com.mmcm.projectocp.backend.spring.domain.service

import com.mmcm.projectocp.backend.spring.application.dto.RoleDTOs
import com.mmcm.projectocp.backend.spring.domain.model.Role
import org.apache.coyote.Response
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
interface RoleService: EntityService<RoleDTOs.GetResult, RoleDTOs.PostRequest, RoleDTOs.PutRequest> {
}