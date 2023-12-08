package com.sp.studypro.service.impl;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.LanguageCoursesMapper;
import com.sp.studypro.mapper.dto.LanguageCoursesDto;
import com.sp.studypro.model.CountriesModel;
import com.sp.studypro.model.LanguageCoursesModel;
import com.sp.studypro.repository.CountriesRepository;
import com.sp.studypro.repository.LanguageCoursesRepository;
import com.sp.studypro.service.LanguageCoursesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageCoursesServiceImpl implements LanguageCoursesService {

    private final LanguageCoursesRepository languageCoursesRepository;
    private final CountriesRepository countriesRepository;
    private final LanguageCoursesMapper languageCoursesMapper;

    public LanguageCoursesServiceImpl(LanguageCoursesRepository languageCoursesRepository, CountriesRepository countriesRepository, LanguageCoursesMapper languageCoursesMapper) {
        this.languageCoursesRepository = languageCoursesRepository;
        this.countriesRepository = countriesRepository;
        this.languageCoursesMapper = languageCoursesMapper;
    }

    @Override
    public LanguageCoursesDto addNewCourse(String name, String description, Double price,
                                           Long countryId, Intake intake, Integer countOfStudents) {
        CountriesModel countriesModel = countriesRepository.findById(countryId)
                .orElseThrow();

        LanguageCoursesModel languageCoursesModel = languageCoursesRepository.save(
                new LanguageCoursesModel(
                        name,
                        description,
                        price,
                        countOfStudents,
                        countriesModel,
                        intake
                )
        );

        return languageCoursesMapper.languageCoursesDto(languageCoursesModel);
    }

    @Override
    public LanguageCoursesDto getCoursesById(Long id) {
        LanguageCoursesModel languageCoursesModel = languageCoursesRepository.getReferenceById(id);
        return languageCoursesMapper.languageCoursesDto(languageCoursesModel);
    }

    @Override
    public List<LanguageCoursesDto> getAllCoursesByIntake(Intake intake) {
        List<LanguageCoursesModel> languageCoursesModels = languageCoursesRepository.findAllByIntake(intake);
        return languageCoursesModels.stream()
                .map(languageCoursesMapper::languageCoursesDto)
                .toList();
    }

    @Override
    public  List<LanguageCoursesDto> getCoursesByCountryId(Long countryId) {
        List<LanguageCoursesModel> languageCoursesModels = languageCoursesRepository.findAllByCountriesId(countryId);
        return languageCoursesModels.stream()
                .map(languageCoursesMapper::languageCoursesDto)
                .toList();
    }

    @Override
    public  List<LanguageCoursesDto> getCoursesByPrice(Double price) {
        List<LanguageCoursesModel> languageCoursesModels = languageCoursesRepository.findAllByPrice(price);
        return languageCoursesModels.stream()
                .map(languageCoursesMapper::languageCoursesDto)
                .toList();
    }

    @Override
    public List<LanguageCoursesDto> getAllCourses() {
        List<LanguageCoursesModel> languageCoursesModels = languageCoursesRepository.findAll();
        return languageCoursesModels.stream()
                .map(languageCoursesMapper::languageCoursesDto)
                .toList();
    }

    @Override
    public LanguageCoursesDto updateCourses(Long id,String name, String description, Double price, Long countryId, Intake intake, Integer countOfStudents) {

        LanguageCoursesModel updateLanguageCoursesModel = languageCoursesRepository.getReferenceById(id);
        if (updateLanguageCoursesModel.getId() == null){
            throw new IllegalArgumentException("Courses id not found");
        }
        CountriesModel updateCountriesModel = countriesRepository.findById(countryId)
                .orElseThrow();

        updateLanguageCoursesModel.setId(id);
        updateLanguageCoursesModel.setName(name);
        updateLanguageCoursesModel.setDescription(description);
        updateLanguageCoursesModel.setPrice(price);
        updateLanguageCoursesModel.setCountries(updateCountriesModel);
        updateLanguageCoursesModel.setIntake(intake);
        updateLanguageCoursesModel.setCountOfStudents(countOfStudents);

        return languageCoursesMapper.languageCoursesDto(updateLanguageCoursesModel);
    }

    @Override
    public void deleteCoursesById(Long id) {
        languageCoursesRepository.deleteById(id);

    }
}
