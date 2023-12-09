package com.sp.studypro.mapper.dto;

import com.sp.studypro.abstract_base.BaseDto;
import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.model.CountriesModel;
import com.sp.studypro.model.UsersModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCoursesDto implements BaseDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer totalClients;
    private CountriesDto countries;
    private Intake intake;
}
