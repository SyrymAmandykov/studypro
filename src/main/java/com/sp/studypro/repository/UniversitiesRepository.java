package com.sp.studypro.repository;

import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.model.UniversitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversitiesRepository extends JpaRepository<UniversitiesModel,Long> {

    @Query("SELECT DISTINCT a FROM UniversitiesModel a JOIN a.programsModelList b WHERE b IN :programsType")
    List<UniversitiesModel> findAllByProgramsType(
            @Param("programsType") ProgramType programsType);
    List<UniversitiesModel> findAllByCountriesCountries(String countries);

}
