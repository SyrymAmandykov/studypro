package com.sp.studypro.mapper.dto;

import com.sp.studypro.abstract_base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectsDto implements BaseDto {

    private Long id;
    private String name;
}
