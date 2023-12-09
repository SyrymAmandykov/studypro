package com.sp.studypro.service;

import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.dto.ProgramsDto;
import com.sp.studypro.mapper.dto.SubjectsDto;

import java.util.List;

public interface ProgramsService {

    ProgramsDto addNewPrograms(String title, String description, Double price, ProgramType programType, List<Long> subjectsIds);
    List<ProgramsDto> getAllProgramsByProgramType(ProgramType programType);
    List<ProgramsDto> getAllPrograms();
    ProgramsDto getProgramsById(Long id);
    List<ProgramsDto> getAllProgramsBySubjectsName(String name);
    ProgramsDto updateProgram(Long id,String title, String description, Double price,
                              ProgramType programType, List<Long> subjectsIds);
    void deleteProgramsById(Long id);

}
