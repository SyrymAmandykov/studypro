package com.sp.studypro.service;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.dto.LanguageCoursesDto;

import java.util.List;

public interface LanguageCoursesService {

    LanguageCoursesDto addNewCourse(String name, String description, Double price, Long countryId, Intake intake,Integer countOfStudents);
    LanguageCoursesDto getCoursesById(Long id);
    List<LanguageCoursesDto> getAllCoursesByIntake(Intake intake);
    List<LanguageCoursesDto> getCoursesByCountryId(Long countryId);
    List<LanguageCoursesDto> getCoursesByPrice(Double price);
    List<LanguageCoursesDto> getAllCourses();
    LanguageCoursesDto updateCourses(Long id,String name,String description, Double price, Long countryId, Intake intake,Integer countOfStudents);
    void deleteCoursesById(Long id);

}
