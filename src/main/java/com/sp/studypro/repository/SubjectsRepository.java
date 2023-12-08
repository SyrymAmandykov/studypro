package com.sp.studypro.repository;

import com.sp.studypro.model.SubjectsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRepository extends JpaRepository<SubjectsModel,Long> {

    List<SubjectsModel> findAllByIdIn(List<Long> ids);
}
