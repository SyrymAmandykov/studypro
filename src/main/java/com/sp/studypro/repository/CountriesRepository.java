package com.sp.studypro.repository;

import com.sp.studypro.model.CountriesModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends JpaRepository<CountriesModel,Long> {

    @Transactional
    CountriesModel findByCountries(String countries);
}
