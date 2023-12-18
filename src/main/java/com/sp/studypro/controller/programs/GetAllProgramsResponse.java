package com.sp.studypro.controller.programs;

import com.sp.studypro.mapper.dto.ProgramsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllProgramsResponse {
    private List<ProgramsDto> programsList;
}
