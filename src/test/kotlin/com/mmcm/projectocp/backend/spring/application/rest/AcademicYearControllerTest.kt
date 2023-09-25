package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYearDTOs
import com.mmcm.projectocp.backend.spring.domain.model.AcademicYear
import com.mmcm.projectocp.backend.spring.domain.repository.AcademicYearRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class AcademicYearControllerTest(
    @Autowired private var mockMvc: MockMvc,
    @Autowired private var academicYearRepository: AcademicYearRepository
) {
    @Test
    @Order(1)
    @WithMockUser(username = "mrlotzo@gmail.com", roles = ["admin"])
    fun getEntities() {
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/api/academic-years")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @Order(2)
    @WithMockUser(username = "mrlotzo@gmail.com", roles = ["admin"])
    fun getEntityById() {
        val entityId = "d47e35a1-5410-11ee-92e0-0242ac170002"
        mockMvc.perform(
            MockMvcRequestBuilders
                .get("/api/academic-years/$entityId")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @Order(3)
    @WithMockUser(username = "mrlotzo@gmail.com", roles = ["admin"])
    fun createEntity() {
        val postRequestJson = """
            {
                "yearFrom": 4021,
                "yearTo": 4022
            }
        """.trimIndent()
        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/api/academic-years")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postRequestJson)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @Order(4)
    @WithMockUser(username = "mrlotzo@gmail.com", roles = ["admin"])
    fun updateEntityById() {
        val academicYearId: String = academicYearRepository.findByYearFrom(4021).id
        val putRequestJson = """
            {
                "yearTo": 5695
            }
        """.trimIndent()
        mockMvc.perform(
            MockMvcRequestBuilders
                .put("/api/academic-years/$academicYearId")
                .contentType(MediaType.APPLICATION_JSON)
                .content(putRequestJson)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @Order(5)
    @WithMockUser(username = "mrlotzo@gmail.com", roles = ["admin"])
    fun deleteEntityById() {
        val academicYearId: String = academicYearRepository.findByYearFrom(4021).id
        mockMvc.perform(
            MockMvcRequestBuilders
                .delete("/api/academic-years/$academicYearId")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
    }
}