package com.sp.studypro.repository;

import com.sp.studypro.model.CommentaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaryRepository extends JpaRepository<CommentaryModel,Long> {

    List<CommentaryModel> findAllByUniversitiesModelId(Long universitiesId);
    List<CommentaryModel> findAllByLanguageCoursesModelId(Long languageCoursesId);
}
