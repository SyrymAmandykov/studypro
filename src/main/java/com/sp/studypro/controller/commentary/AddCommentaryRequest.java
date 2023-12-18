package com.sp.studypro.controller.commentary;

import com.sp.studypro.mapper.dto.LanguageCoursesDto;
import com.sp.studypro.mapper.dto.UniversitiesDto;
import com.sp.studypro.mapper.dto.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentaryRequest {

    private String title;
    private String text;
    private Long universitiesId;
    private Long languageCoursesId;
    private Long usersId;
}
