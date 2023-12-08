package com.sp.studypro.repository;

import com.sp.studypro.model.LanguageCoursesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageCoursesRepository extends JpaRepository<LanguageCoursesModel,Long> {
}
