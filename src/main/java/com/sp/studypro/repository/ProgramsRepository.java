package com.sp.studypro.repository;

import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.model.ProgramsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramsRepository extends JpaRepository<ProgramsModel,Long> {

    List<ProgramsModel> findAllByIdIn(List<Long> ids);
    List<ProgramsModel> findAllByProgramType(ProgramType programType);
    List<ProgramsModel> findAllBySubjectsModelName(String name);

}
