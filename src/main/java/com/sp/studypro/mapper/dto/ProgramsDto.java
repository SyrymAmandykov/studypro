package com.sp.studypro.mapper.dto;

import com.sp.studypro.abstract_base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgramsDto implements BaseDto {

    private String underGraduate;
    private String postGraduate;
}
