package com.mmcm.projectocp.backend.spring.application.rest

import com.mmcm.projectocp.backend.spring.application.dto.AcademicYeartDto
import com.mmcm.projectocp.backend.spring.domain.model.AcademicYear
import com.mmcm.projectocp.backend.spring.domain.repository.AcademicYearRepository
import com.mmcm.projectocp.backend.spring.domain.service.AcademicYearService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/academic-years")
class AcademicYearController (
    private val academicYearRepository: AcademicYearRepository,
    private val academicYearService: AcademicYearService
){
    @GetMapping
    fun getAcademicYears(pageable: Pageable): Page<AcademicYear> {
        return academicYearRepository.findAll(pageable)
    }
    @GetMapping("/id={id}")
    fun getAcademicYearById(
        @PathVariable("id") academicYearId: String,
        pageable: Pageable
    ): AcademicYear {
        return academicYearRepository.findById(academicYearId).orElseThrow { Exception("AcademicYear not found") }
    }

    @GetMapping("/year={year}")
    fun getAcademicYearByYear(
        @PathVariable("year") year: Int,
        pageable: Pageable
    ): Page<AcademicYear> {
        return academicYearRepository.findByYearFromLessThanEqualAndYearToGreaterThanEqual(year, year, pageable).orElseThrow { Exception("AcademicYear not found") }
    }


    @PostMapping("/create-academic-year")
    fun createUser(@RequestBody req: AcademicYeartDto): AcademicYeartDto {
        return academicYearService.createAcademicYear(req)

    }

    @PutMapping("/update-academic-year/id={id}")
    fun updateUser(
        @PathVariable("id") academicYearId: String,
        @RequestBody req: AcademicYeartDto
    ): AcademicYeartDto {
        return academicYearService.updateAcademicYearById(academicYearId, req)
    }

    @DeleteMapping("/delete-academic-year/id={id}")
    fun deleteUser(@PathVariable("id") academicYearId: String) {
        academicYearService.deleteAcademicYearById(academicYearId)
    }



}