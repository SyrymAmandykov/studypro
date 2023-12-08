package com.sp.studypro.service.impl;

import com.sp.studypro.mapper.CountriesMapper;
import com.sp.studypro.mapper.dto.CountriesDto;
import com.sp.studypro.model.CountriesModel;
import com.sp.studypro.repository.CountriesRepository;
import com.sp.studypro.service.CountriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesServiceImpl implements CountriesService {

    private final CountriesRepository countriesRepository;
    private final CountriesMapper countriesMapper;

    public CountriesServiceImpl(CountriesRepository countriesRepository, CountriesMapper countriesMapper) {
        this.countriesRepository = countriesRepository;
        this.countriesMapper = countriesMapper;
    }

    @Override
    public CountriesDto addNewCountries(String countries) {
        CountriesModel countriesModel = countriesRepository.save(
                new CountriesModel(
                        countries
                )
        );

        return countriesMapper.toCountriesDto(countriesModel);
    }

    @Override
    public CountriesDto getCountriesById(Long id) {
        CountriesModel countriesModel = countriesRepository.findById(id)
                .orElseThrow();
        return countriesMapper.toCountriesDto(countriesModel);
    }

    @Override
    public List<CountriesDto> getAllCountries() {
        List<CountriesModel> countriesModels = countriesRepository.findAll();
        return countriesModels.stream()
                .map(countriesMapper::toCountriesDto)
                .toList();
    }

    @Override
    public CountriesDto updateCountries(Long id, String countries) {
        CountriesModel updateCountriesModel = countriesRepository.findById(id)
                .orElseThrow();

        updateCountriesModel.setId(id);
        updateCountriesModel.setCountries(countries);

        return countriesMapper.toCountriesDto(updateCountriesModel);
    }

    @Override
    public void deleteCountriesById(Long id) {
        countriesRepository.deleteById(id);
    }
}
