package com.sp.studypro.controller;

import com.sp.studypro.controller.commentary.AddCommentaryRequest;
import com.sp.studypro.controller.commentary.GetAllCommentsResponse;
import com.sp.studypro.mapper.dto.CommentaryDto;
import com.sp.studypro.service.CommentaryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/commentaries")
public class CommentaryController {

    private final CommentaryService commentaryService;

    public CommentaryController(CommentaryService commentaryService) {
        this.commentaryService = commentaryService;
    }

    @PostMapping("/add/toUniversity")
    @ResponseBody
    public CommentaryDto addNewCommentaryToUniversity(
            @RequestBody AddCommentaryRequest commentary
            ){
        return commentaryService.addNewCommentaryToUniversity(
                commentary.getTitle(),
                commentary.getText(),
                commentary.getUniversitiesId(),
                commentary.getUsersId()
        );
    }

    @PostMapping("/add/toLanguageCourses")
    @ResponseBody
    public CommentaryDto addNewCommentaryToLanguageCourses(
            @RequestBody AddCommentaryRequest commentary
    ){
        return commentaryService.addNewCommentaryToCourses(
                commentary.getTitle(),
                commentary.getText(),
                commentary.getLanguageCoursesId(),
                commentary.getUsersId()
        );
    }

    @GetMapping("/all/{universityId}")
    @ResponseBody
    public GetAllCommentsResponse getAllCommentsByUniversityId(
            @PathVariable Long universityId
    ){
        return (GetAllCommentsResponse) commentaryService.getAllCommentariesByUniversitiesId(universityId);
    }

    @GetMapping("/all/{languageCoursesId}")
    @ResponseBody
    public GetAllCommentsResponse getAllCommentsByLanguageCoursesId(
            @PathVariable Long languageCoursesId
    ){
        return (GetAllCommentsResponse) commentaryService.getAllCommentariesByLanguageCoursesId(languageCoursesId);
    }

    @DeleteMapping("/delete/{deleteById}")
    @ResponseBody
    public void deleteCommentsById(
            @PathVariable Long deleteById
    ){
        commentaryService.deleteCommentaryById(deleteById);
    }

}
