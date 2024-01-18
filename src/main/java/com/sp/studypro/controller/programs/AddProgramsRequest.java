package com.sp.studypro.controller.programs;

import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.dto.SubjectsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProgramsRequest {

    private String title;
    private String description;
    private Double price;
    private ProgramType programType;
    private List<SubjectsDto> subjectsModel;
}
