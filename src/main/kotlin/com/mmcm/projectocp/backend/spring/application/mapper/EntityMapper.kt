package com.mmcm.projectocp.backend.spring.application.mapper

interface EntityMapper<Entity, GetResult, PostRequest, PutRequest> {
    fun toGetResult(entity: Entity): GetResult
    fun createEntity(id: String, entityRequest: PostRequest): Entity
    fun updateEntity(entity: Entity, entityRequest: PutRequest): Entity
}
