package com.sp.studypro.repository;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.model.LanguageCoursesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageCoursesRepository extends JpaRepository<LanguageCoursesModel,Long> {

    List<LanguageCoursesModel> findAllByIntake(Intake intake);
    List<LanguageCoursesModel> findAllByCountriesId(Long countriesId);
    List<LanguageCoursesModel> findAllByPrice(Double price);
}
