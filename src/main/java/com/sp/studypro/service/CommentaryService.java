package com.sp.studypro.service;

import com.sp.studypro.mapper.dto.CommentaryDto;

import java.util.List;

public interface CommentaryService {

    CommentaryDto addNewCommentaryToUniversity(String title,String text,Long universityId,Long userId);
    CommentaryDto addNewCommentaryToCourses(String title,String text,Long languageCoursesId,Long userId);
    List<CommentaryDto> getAllCommentariesByUniversitiesId(Long universityId);
    List<CommentaryDto> getAllCommentariesByLanguageCoursesId(Long languageCoursesId);
    void deleteCommentaryById(Long id);
}
