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
        List<UniversitiesModel> universitiesModels = universitiesRepository.findAllByCountriesCountries(countries);
        return universitiesModels.stream()
                .map(universitiesMapper::toUniversitiesDto)
                .toList();
    }

    @Override
    public List<UniversitiesDto> getAllUniversityByProgramName(String programName) {
        List<UniversitiesModel> universitiesModels = universitiesRepository.findAllByPrograms(programName);
        return universitiesModels.stream()
                .map(universitiesMapper::toUniversitiesDto)
                .toList();
    }

    @Override
    public UniversitiesDto updateUniversities(Long id, String name, String description, Double price, Integer countOfStudents,
                                              List<Long> programIds, List<Long> subjectIds, Long countryIds, Intake intake) {
// в дальнейшем все заменю на Optional + Exception
        UniversitiesModel updateUniversitiesModel = universitiesRepository.getReferenceById(id);
        if (updateUniversitiesModel.getId() == null) {
            throw new IllegalArgumentException("University id not found");
        }
        List<ProgramsModel> updateProgramModel = programsRepository.findAllByIdIn(programIds);
        if (updateProgramModel == null) {
            throw new IllegalArgumentException("Programs not found");
        }
        List<SubjectsModel> updateSubjectsModel = subjectsRepository.findAllByIdIn(subjectIds);
        if (updateSubjectsModel == null) {
            throw new IllegalArgumentException("Subjects id not found");
        }
        CountriesModel updateCountriesModel = countriesRepository.findById(countryIds)
                .orElseThrow();

        updateUniversitiesModel.setId(id);
        updateUniversitiesModel.setName(name);
        updateUniversitiesModel.setDescription(description);
        updateUniversitiesModel.setPrice(price);
        updateUniversitiesModel.setCountOfStudents(countOfStudents);
        updateUniversitiesModel.setProgramsModelList(updateProgramModel);
        updateUniversitiesModel.setCountries(updateCountriesModel);
        updateUniversitiesModel.setSubjectsModelList(updateSubjectsModel);
        updateUniversitiesModel.setIntake(intake);

        return universitiesMapper.toUniversitiesDto(updateUniversitiesModel);
    }

    @Override
    public void deleteUniversitiesById(Long id) {
        universitiesRepository.deleteById(id);

    }
}
