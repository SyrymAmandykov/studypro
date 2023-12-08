package com.sp.studypro.service;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.dto.UniversitiesDto;

import java.util.List;

public interface UniversitiesService {

    UniversitiesDto addNewUniversity(String name, String description, Double price,
                                     List<Long> programIds, List<Long> subjectIds, Long countryIds, Intake intake);

    List<UniversitiesDto> getAllUniversities();
    UniversitiesDto getUniversityById(Long id);
    List<UniversitiesDto> getAllUniversityByCountries(String countries);
    List<UniversitiesDto> getAllUniversityByProgramName(String programName);

    UniversitiesDto updateUniversities(Long id, String name, String description, Double price, Integer countOfStudents,
                                       List<Long> programIds, List<Long> subjectIds, Long countryIds, Intake intake);

    void deleteUniversitiesById(Long id);

}
