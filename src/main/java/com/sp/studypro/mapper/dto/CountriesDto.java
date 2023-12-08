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
public class CountriesDto implements BaseDto {
    private String countries;
}
