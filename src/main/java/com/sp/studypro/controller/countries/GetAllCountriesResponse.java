package com.sp.studypro.controller.countries;

import com.sp.studypro.mapper.dto.CountriesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetAllCountriesResponse {
    private List<CountriesDto> countries;
}
