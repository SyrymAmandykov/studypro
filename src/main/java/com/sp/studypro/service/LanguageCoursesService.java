package com.sp.studypro.service;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.dto.LanguageCoursesDto;

import java.util.List;

public interface LanguageCoursesService {

    LanguageCoursesDto addNewCourse(String name, String description, Double price, Long countryId, Intake intake,Integer countOfStudents);
    LanguageCoursesDto getCoursesById(Long id);
    LanguageCoursesDto getCoursesByIntake(Intake intake);
    LanguageCoursesDto getCoursesByCountryId(Long countryId);
    LanguageCoursesDto getCoursesByPrice(Double price);
    List<LanguageCoursesDto> getAllCourses();
    LanguageCoursesDto updateCourses(Long id,String description, Double price, Long countryId, Intake intake,Integer countOfStudents);
    void deleteCoursesById(Long id);

}
