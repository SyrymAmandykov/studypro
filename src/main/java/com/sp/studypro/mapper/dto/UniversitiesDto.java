package com.sp.studypro.mapper.dto;

import com.sp.studypro.abstract_base.BaseDto;
import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.enum_package.Role;
import com.sp.studypro.model.CountriesModel;
import com.sp.studypro.model.ProgramsModel;
import com.sp.studypro.model.SubjectsModel;
import com.sp.studypro.model.UsersModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UniversitiesDto implements BaseDto {

    private String name;
    private String description;
    private Double price;
    private Integer countOfStudents;
    private List<ProgramsModel> programsModelList;
    private List<SubjectsModel> subjectsModelList;
    private CountriesModel countries;
    private Intake intake;
}
