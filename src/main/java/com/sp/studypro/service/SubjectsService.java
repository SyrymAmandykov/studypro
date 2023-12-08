package com.sp.studypro.service;

import com.sp.studypro.mapper.dto.SubjectsDto;

import java.util.List;

public interface SubjectsService {

    SubjectsDto addNewSubjects(String name);
    SubjectsDto getSubjectsById(Long id);
    List<SubjectsDto> getAllSubjects();
    SubjectsDto updateSubjects(Long id, String name);
    void deleteSubjectsById(Long id);
}
