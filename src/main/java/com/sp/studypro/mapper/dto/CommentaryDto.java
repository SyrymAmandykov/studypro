package com.sp.studypro.mapper.dto;

import com.sp.studypro.abstract_base.BaseDto;
import com.sp.studypro.model.LanguageCoursesModel;
import com.sp.studypro.model.UniversitiesModel;
import com.sp.studypro.model.UsersModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentaryDto implements BaseDto {

    private String title;
    private String text;
    private UniversitiesModel universitiesModel;
    private LanguageCoursesModel languageCoursesModel;
    private UsersModel usersModel;
}
