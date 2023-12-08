package com.sp.studypro.service.impl;

import com.sp.studypro.mapper.CommentaryMapper;
import com.sp.studypro.mapper.dto.CommentaryDto;
import com.sp.studypro.model.CommentaryModel;
import com.sp.studypro.model.LanguageCoursesModel;
import com.sp.studypro.model.UniversitiesModel;
import com.sp.studypro.model.UsersModel;
import com.sp.studypro.repository.CommentaryRepository;
import com.sp.studypro.repository.LanguageCoursesRepository;
import com.sp.studypro.repository.UniversitiesRepository;
import com.sp.studypro.repository.UsersRepository;
import com.sp.studypro.service.CommentaryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryServiceImpl implements CommentaryService {

    private final CommentaryRepository commentaryRepository;
    private final CommentaryMapper commentaryMapper;

    private final UniversitiesRepository universitiesRepository;
    private final LanguageCoursesRepository languageCoursesRepository;
    private final UsersRepository usersRepository;

    public CommentaryServiceImpl(CommentaryRepository commentaryRepository, CommentaryMapper commentaryMapper, UniversitiesRepository universitiesRepository, LanguageCoursesRepository languageCoursesRepository, UsersRepository usersRepository) {
        this.commentaryRepository = commentaryRepository;
        this.commentaryMapper = commentaryMapper;
        this.universitiesRepository = universitiesRepository;
        this.languageCoursesRepository = languageCoursesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public CommentaryDto addNewCommentaryToUniversity(String title, String text,
                                                      Long userId,Long universityId) {
        UsersModel usersModel = usersRepository.getReferenceById(userId);
        UniversitiesModel universitiesModel = universitiesRepository.getReferenceById(universityId);

        CommentaryModel commentaryModel = commentaryRepository.save(
                new CommentaryModel(
                        title,
                        text,
                        universitiesModel,
                        null,
                        usersModel
                )
        );

        return commentaryMapper.toCommentaryDto(commentaryModel);
    }

    @Override
    public CommentaryDto addNewCommentaryToCourses(String title, String text, Long languageCoursesId, Long userId) {
        UsersModel usersModel = usersRepository.getReferenceById(userId);
        LanguageCoursesModel languageCoursesModel = languageCoursesRepository.getReferenceById(languageCoursesId);

        CommentaryModel commentaryModel = commentaryRepository.save(
                new CommentaryModel(
                        title,
                        text,
                        null,
                        languageCoursesModel,
                        usersModel
                )
        );

        return commentaryMapper.toCommentaryDto(commentaryModel);
    }

    @Override
    public List<CommentaryDto> getAllCommentariesByUniversitiesId(Long universityId) {
        List<CommentaryModel> commentaryModels = commentaryRepository.findAllByUniversitiesModelId(universityId);
        return commentaryModels.stream()
                .map(commentaryMapper::toCommentaryDto)
                .toList();
    }

    @Override
    public List<CommentaryDto> getAllCommentariesByLanguageCoursesId(Long languageCoursesId) {
        List<CommentaryModel> commentaryModel = commentaryRepository.findAllByLanguageCoursesModelId(languageCoursesId);
        return commentaryModel.stream()
                .map(commentaryMapper::toCommentaryDto)
                .toList();
    }

    @Override
    public void deleteCommentaryById(Long id) {
        commentaryRepository.deleteById(id);
    }
}
