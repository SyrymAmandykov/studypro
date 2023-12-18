package com.sp.studypro.controller.languageCourses;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.dto.CountriesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageCoursesRequest {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer totalClients;
    private CountriesDto countries;
    private Intake intake;

}
