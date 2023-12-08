package com.sp.studypro.service;

import com.sp.studypro.mapper.dto.ProgramsDto;

import java.util.List;

public interface ProgramsService {

    ProgramsDto addNewPrograms(String underGraduate,String postGraduate);
    ProgramsDto addNewUnderGraduate(String underGraduate);
    ProgramsDto addNewPostGraduate(String postGraduate);
    List<ProgramsDto> getProgramByUnderGraduate(String underGraduate);
    List<ProgramsDto>  getProgramByPostGraduate(String postGraduate);
    List<ProgramsDto> getAllPrograms();

    ProgramsDto getProgramsById(Long id);
    ProgramsDto updateProgram(Long id,String underGraduate,String postGraduate);
    void deleteProgramsById(Long id);

}
