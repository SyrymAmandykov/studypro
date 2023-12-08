package com.sp.studypro.service;

import com.sp.studypro.mapper.dto.CountriesDto;

import java.util.List;

public interface CountriesService {
    CountriesDto addNewCountries(String countries);
    CountriesDto getCountriesById(Long id);
    List<CountriesDto> getAllCountries();
    CountriesDto updateCountries(Long id, String countries);
    void deleteCountriesById(Long id);
}
