package com.sp.studypro.controller.subjects;

import com.sp.studypro.mapper.dto.SubjectsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubjectsResponse {
    List<SubjectsDto> subjectsList;
}
