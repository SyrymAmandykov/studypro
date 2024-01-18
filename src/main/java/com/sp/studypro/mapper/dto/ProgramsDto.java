package com.sp.studypro.mapper.dto;

import com.sp.studypro.abstract_base.BaseDto;
import com.sp.studypro.enum_package.ProgramType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgramsDto implements BaseDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private ProgramType programType;
    private List<SubjectsDto> subjectsModel;
}
