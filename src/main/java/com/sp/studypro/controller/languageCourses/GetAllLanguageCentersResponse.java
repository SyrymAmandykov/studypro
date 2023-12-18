package com.sp.studypro.controller.languageCourses;

import com.sp.studypro.mapper.dto.LanguageCoursesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguageCentersResponse {
    private List<LanguageCoursesDto> centers;
}
