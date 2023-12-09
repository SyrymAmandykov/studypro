package com.sp.studypro.service.impl;

import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.UniversitiesMapper;
import com.sp.studypro.mapper.dto.UniversitiesDto;
import com.sp.studypro.model.CountriesModel;
import com.sp.studypro.model.ProgramsModel;
import com.sp.studypro.model.UniversitiesModel;
import com.sp.studypro.repository.CountriesRepository;
import com.sp.studypro.repository.ProgramsRepository;
import com.sp.studypro.repository.UniversitiesRepository;
import com.sp.studypro.service.UniversitiesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversitiesServiceImpl implements UniversitiesService {

    private final UniversitiesRepository universitiesRepository;
    private final ProgramsRepository programsRepository;
    private final CountriesRepository countriesRepository;
    private final UniversitiesMapper universitiesMapper;

    public UniversitiesServiceImpl(UniversitiesRepository universitiesRepository, ProgramsRepository programsRepository, CountriesRepository countriesRepository, UniversitiesMapper universitiesMapper) {
        this.universitiesRepository = universitiesRepository;
        this.programsRepository = programsRepository;
        this.countriesRepository = countriesRepository;
        this.universitiesMapper = universitiesMapper;
    }

    @Override
    public UniversitiesDto addNewUniversity(String name, String description,Integer totalClients,
                                            List<Long> programsIds, Long countryIds, Intake intake) {

        List<ProgramsModel> programsModel = programsRepository.findAllByIdIn(programsIds);
        CountriesModel countriesModel = countriesRepository.findById(countryIds)
                .orElseThrow();

        UniversitiesModel universitiesModel = universitiesRepository.save(
                new UniversitiesModel(
                        name,
                        description,
                        totalClients,
                        programsModel,
                        countriesModel,
                        intake
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
    public List<UniversitiesDto> getAllUniversityByProgramType(ProgramType programType) {
        List<UniversitiesModel> universitiesModels = universitiesRepository.findAllByProgramsType(programType);
        return universitiesModels.stream()
                .map(universitiesMapper::toUniversitiesDto)
                .toList();
    }

    @Override
    public UniversitiesDto updateUniversities(Long id, String name, String description,Integer totalClients,
                                              List<Long> programIds, Long countryIds, Intake intake) {
// в дальнейшем все заменю на Optional + Exception
        UniversitiesModel updateUniversitiesModel = universitiesRepository.getReferenceById(id);
        if (updateUniversitiesModel.getId() == null) {
            throw new IllegalArgumentException("University id not found");
        }
        List<ProgramsModel> updateProgramModel = programsRepository.findAllByIdIn(programIds);
        if (updateProgramModel == null) {
            throw new IllegalArgumentException("Programs not found");
        }
        CountriesModel updateCountriesModel = countriesRepository.findById(countryIds)
                .orElseThrow();

        updateUniversitiesModel.setId(id);
        updateUniversitiesModel.setName(name);
        updateUniversitiesModel.setDescription(description);
        updateUniversitiesModel.setTotalClients(totalClients);
        updateUniversitiesModel.setProgramsModelList(updateProgramModel);
        updateUniversitiesModel.setCountries(updateCountriesModel);
        updateUniversitiesModel.setIntake(intake);

        universitiesRepository.save(
                updateUniversitiesModel
        );

        return universitiesMapper.toUniversitiesDto(updateUniversitiesModel);
    }

    @Override
    public void deleteUniversitiesById(Long id) {
        universitiesRepository.deleteById(id);

    }
}
