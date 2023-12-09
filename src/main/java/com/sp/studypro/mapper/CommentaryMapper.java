package com.sp.studypro.mapper;

import com.sp.studypro.mapper.dto.CommentaryDto;
import com.sp.studypro.model.CommentaryModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR,uses = {UserMapper.class, UniversitiesMapper.class, LanguageCoursesMapper.class})
public interface CommentaryMapper {

    CommentaryDto toCommentaryDto(CommentaryModel commentaryModel);

}
