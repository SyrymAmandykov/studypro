package com.sp.studypro.repository;

import com.sp.studypro.model.UniversitiesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversitiesRepository extends JpaRepository<UniversitiesModel,Long> {
}
