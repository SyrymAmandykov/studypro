package com.sp.studypro.controller.universities;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.dto.CountriesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUniversitiesRequest {

    private Long id;
    private String name;
    private String description;
    private Integer totalClients;
    private List<Long> programsId;
    private CountriesDto countries;
    private Intake intake;
}
