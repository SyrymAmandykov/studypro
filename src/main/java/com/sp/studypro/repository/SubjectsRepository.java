package com.sp.studypro.repository;

import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.dto.SubjectsDto;
import com.sp.studypro.model.SubjectsModel;
import com.sp.studypro.model.UniversitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository extends JpaRepository<SubjectsModel,Long> {

    List<SubjectsModel> findAllByIdIn(List<Long> ids);

    List<SubjectsModel> findSubjectsModelByNameIn(List<String> subjectsName);
}
