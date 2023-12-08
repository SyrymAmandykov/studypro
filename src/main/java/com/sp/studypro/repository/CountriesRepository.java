package com.sp.studypro.repository;

import com.sp.studypro.model.CountriesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<CountriesModel,Long> {

}
