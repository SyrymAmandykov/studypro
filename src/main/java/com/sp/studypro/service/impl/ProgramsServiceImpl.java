package com.sp.studypro.service.impl;

import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.ProgramsMapper;
import com.sp.studypro.mapper.dto.ProgramsDto;
import com.sp.studypro.mapper.dto.SubjectsDto;
import com.sp.studypro.model.ProgramsModel;
import com.sp.studypro.model.SubjectsModel;
import com.sp.studypro.repository.ProgramsRepository;
import com.sp.studypro.repository.SubjectsRepository;
import com.sp.studypro.service.ProgramsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramsServiceImpl implements ProgramsService {

    private final ProgramsRepository programsRepository;
    private final ProgramsMapper programsMapper;
    private final SubjectsRepository subjectsRepository;

    public ProgramsServiceImpl(ProgramsRepository programsRepository, ProgramsMapper programsMapper, SubjectsRepository subjectsRepository) {
        this.programsRepository = programsRepository;
        this.programsMapper = programsMapper;
        this.subjectsRepository = subjectsRepository;
    }

    @Override
    public ProgramsDto addNewPrograms(String title, String description, Double price,
                                      ProgramType programType, List<SubjectsDto> subjects) {
        List<SubjectsModel> subjectsModel = subjectsRepository.findSubjectsModelByNameIn(subjects
                .stream()
                .map(SubjectsDto::getName)
                .toList());

        ProgramsModel programsModel = programsRepository.save(
                new ProgramsModel(
                        title,
                        description,
                        price,
                        programType,
                        subjectsModel
                )
        );

        return programsMapper.toProgramsDto(programsModel);
    }

    @Override
    public List<ProgramsDto> getAllPrograms() {
        List<ProgramsModel> programsModels = programsRepository.findAll();
        return programsModels.stream()
                .map(programsMapper::toProgramsDto)
                .toList();
    }

    @Override
    public ProgramsDto getProgramsById(Long id) {
        ProgramsModel programsModel = programsRepository.findById(id)
                .orElseThrow();
        return programsMapper.toProgramsDto(programsModel);
    }

    @Override
    public List<ProgramsDto> getAllProgramsByProgramType(ProgramType programType) {
        List<ProgramsModel> programsModel = programsRepository.findAllByProgramType(programType);
        return programsModel.stream()
                .map(programsMapper::toProgramsDto)
                .toList();
    }

    @Override
    public List<ProgramsDto> getAllProgramsBySubjectsName(String name) {
        List<ProgramsModel> programsModels = programsRepository.findAllBySubjectsModelName(name);
        return programsModels.stream()
                .map(programsMapper::toProgramsDto)
                .toList();
    }

    @Override
    public ProgramsDto updateProgram(Long id,String title, String description, Double price,
                                     ProgramType programType, List<SubjectsDto> subjects) {
        ProgramsModel upgradeProgramsModels = programsRepository.findById(id)
                .orElseThrow();
        List<SubjectsModel> upgradeSubjectsModels = subjectsRepository.findSubjectsModelByNameIn(subjects
                .stream()
                .map(SubjectsDto::getName)
                .toList());
        if (upgradeSubjectsModels.isEmpty()) {
            throw new IllegalArgumentException("Subjects id not found");
        }

        upgradeProgramsModels.setId(id);
        upgradeProgramsModels.setTitle(title);
        upgradeProgramsModels.setDescription(description);
        upgradeProgramsModels.setPrice(price);
        upgradeProgramsModels.setProgramType(programType);
        upgradeProgramsModels.setSubjectsModel(upgradeSubjectsModels);

        programsRepository.save(
                upgradeProgramsModels
        );

        return programsMapper.toProgramsDto(upgradeProgramsModels);
    }

    @Override
    public void deleteProgramsById(Long id) {
        programsRepository.deleteById(id);
    }
}
