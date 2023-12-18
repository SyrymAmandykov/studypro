package com.sp.studypro.service;

import com.sp.studypro.controller.universities.AddUniversitiesRequest;
import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.dto.CountriesDto;
import com.sp.studypro.mapper.dto.ProgramsDto;
import com.sp.studypro.mapper.dto.UniversitiesDto;

import java.util.List;

public interface UniversitiesService {

    UniversitiesDto addNewUniversity(String name, String description, Integer totalClients,
                                     List<Long> programsIds, Long countryIds, Intake intake);

    List<UniversitiesDto> getAllUniversities();
    UniversitiesDto getUniversityById(Long id);
    List<UniversitiesDto> getAllUniversityByCountries(String countryName);
    List<UniversitiesDto> getAllUniversityByProgramType(ProgramType programType);

    UniversitiesDto updateUniversities(Long id, String name, String description,Integer totalClients,
                                       List<Long> programIds, Long countryIds, Intake intake);

    void deleteUniversitiesById(Long id);

    UniversitiesDto addNewUniversity(AddUniversitiesRequest addUniversitiesRequest);
}
