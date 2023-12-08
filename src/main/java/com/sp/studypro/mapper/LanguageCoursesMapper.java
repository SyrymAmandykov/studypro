package com.sp.studypro.mapper;

import com.sp.studypro.mapper.dto.LanguageCoursesDto;
import com.sp.studypro.model.LanguageCoursesModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LanguageCoursesMapper {

    LanguageCoursesDto languageCoursesDto(LanguageCoursesModel languageCoursesModel);

}
