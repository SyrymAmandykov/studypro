package com.sp.studypro.controller.universities;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.dto.CountriesDto;
import com.sp.studypro.mapper.dto.ProgramsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUniversitiesRequest {

    private String name;
    private String description;
    private Double price;
    private Integer totalClients;
    private List<ProgramsDto> programsModelList;
    private CountriesDto countries;
    private Intake intake;
}
