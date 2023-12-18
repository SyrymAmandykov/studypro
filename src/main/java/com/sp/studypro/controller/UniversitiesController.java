package com.sp.studypro.controller;

import com.sp.studypro.controller.universities.AddUniversitiesRequest;
import com.sp.studypro.controller.universities.GetAllUniversitiesResponse;
import com.sp.studypro.controller.universities.UpdateUniversitiesRequest;
import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.dto.UniversitiesDto;
import com.sp.studypro.service.CountriesService;
import com.sp.studypro.service.ProgramsService;
import com.sp.studypro.service.UniversitiesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/universities")
public class UniversitiesController {

    private final UniversitiesService universitiesService;

    public UniversitiesController(UniversitiesService universitiesService) {
        this.universitiesService = universitiesService;
    }

    @PostMapping("/add")
    @ResponseBody
    public UniversitiesDto addNewUniversity(
            @RequestBody AddUniversitiesRequest addUniversitiesRequest
    ){
        return universitiesService.addNewUniversity(
                addUniversitiesRequest.getName(),
                addUniversitiesRequest.getDescription(),
                addUniversitiesRequest.getTotalClients(),
                addUniversitiesRequest.getProgramsId(),
                addUniversitiesRequest.getCountriesId(),
                addUniversitiesRequest.getIntake()
        );
    }

    @GetMapping("/all")
    @ResponseBody
    public GetAllUniversitiesResponse getAllUniversities(){
        List<UniversitiesDto> universitiesList = universitiesService.getAllUniversities();
        return new GetAllUniversitiesResponse(universitiesList);
    }

    @GetMapping("/by-universityId/{universityId}")
    @ResponseBody
    public UniversitiesDto getUniversityById(
            @PathVariable Long universityId
    ){
        return universitiesService.getUniversityById(universityId);
    }

    @GetMapping("/by-countryName")
    @ResponseBody
    public GetAllUniversitiesResponse getAllUniversitiesByCountry(
            @RequestBody String countryName
    ){
        return (GetAllUniversitiesResponse) universitiesService.getAllUniversityByCountries(countryName);
    }

    @GetMapping("/by-programType")
    @ResponseBody
    public GetAllUniversitiesResponse getAlluniversitiesByProgramType(
            @RequestBody ProgramType programType
            ){
        return (GetAllUniversitiesResponse) universitiesService.getAllUniversityByProgramType(programType);
    }

    @PutMapping("/update")
    @ResponseBody
    public UniversitiesDto updateUniversity(
            @RequestBody UpdateUniversitiesRequest universities
    ){
        return universitiesService.updateUniversities(
                universities.getId(),
                universities.getName(),
                universities.getDescription(),
                universities.getTotalClients(),
                universities.getProgramsId(),
                universities.getCountries().getId(),
                universities.getIntake()
        );
    }


    @DeleteMapping("/delete/{deleteById}")
    @ResponseBody
    public void deleteUniversityById(
            @PathVariable Long deleteById
    ){
         universitiesService.deleteUniversitiesById(deleteById);
    }
}
