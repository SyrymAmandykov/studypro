package com.sp.studypro.service.impl;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.UniversitiesMapper;
import com.sp.studypro.mapper.dto.UniversitiesDto;
import com.sp.studypro.model.CountriesModel;
import com.sp.studypro.model.ProgramsModel;
import com.sp.studypro.model.SubjectsModel;
import com.sp.studypro.model.UniversitiesModel;
import com.sp.studypro.repository.CountriesRepository;
import com.sp.studypro.repository.ProgramsRepository;
import com.sp.studypro.repository.SubjectsRepository;
import com.sp.studypro.repository.UniversitiesRepository;
import com.sp.studypro.service.UniversitiesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversitiesServiceImpl implements UniversitiesService {

    private final UniversitiesRepository universitiesRepository;
    private final ProgramsRepository programsRepository;
    private final SubjectsRepository subjectsRepository;
    private final CountriesRepository countriesRepository;
    private final UniversitiesMapper universitiesMapper;

    public UniversitiesServiceImpl(UniversitiesRepository universitiesRepository, ProgramsRepository programsRepository, SubjectsRepository subjectsRepository, CountriesRepository countriesRepository, UniversitiesMapper universitiesMapper) {
        this.universitiesRepository = universitiesRepository;
        this.programsRepository = programsRepository;
        this.subjectsRepository = subjectsRepository;
        this.countriesRepository = countriesRepository;
        this.universitiesMapper = universitiesMapper;
    }

    @Override
    public UniversitiesDto addNewUniversity(String name, String description, Double price,
                                            List<Long> programIds, List<Long> subjectIds, Long countryIds, Intake intake) {

        List<ProgramsModel> programsModel = programsRepository.findAllByIdIn(programIds);
        List<SubjectsModel> subjectsModel = subjectsRepository.findAllByIdIn(subjectIds);
        CountriesModel countriesModel = countriesRepository.findById(countryIds)
                .orElseThrow();

        UniversitiesModel universitiesModel = universitiesRepository.save(
                new UniversitiesModel(
                        name,
                        description,
                        price,
                        null,
                        programsModel,
                        subjectsModel,
                        countriesModel,
                        null
                )
        );

        return universitiesMapper.toUniversitiesDto(universitiesModel);
    }

    @Override
    public List<UniversitiesDto> getAllUniversities() {
        List<UniversitiesModel> universitiesModels = universitiesRepository.findAll();
        return universitiesModels.stream()
                .map(universitiesMapper::toUniversitiesDto)
                .toList();
    }

    @Override
    public UniversitiesDto getUniversityById(Long id) {
        UniversitiesModel universitiesModels = universitiesRepository.findById(id)
                .orElseThrow();
        return universitiesMapper.toUniversitiesDto(universitiesModels);
    }

    @Override
    public List<UniversitiesDto> getAllUniversityByCountries(String countries) {
        CountriesModel countriesModel = countriesRepository.findByCountries(countries);

        ArrayList<CountriesModel> countriesModels = new ArrayList<>();
        countriesModels.add(countriesModel);

        return  universitiesMapper.toUniversitiesDto(countriesModel);
    }

    @Override
    public UniversitiesDto getUniversityByProgramName(List<String> programName) {
        return null;
    }

    @Override
    public UniversitiesDto updateUniversities(Long id, String name, String description, Double price, Integer countOfStudents, List<Long> programIds, List<Long> subjectIds, Long countryIds, Intake intake) {
        return null;
    }

    @Override
    public void deleteUniversitiesById(Long id) {

    }
}
