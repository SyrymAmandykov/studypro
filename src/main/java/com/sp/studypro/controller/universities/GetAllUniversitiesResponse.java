package com.sp.studypro.controller.universities;

import com.sp.studypro.mapper.dto.UniversitiesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUniversitiesResponse {

    List<UniversitiesDto> universitiesList;


}
