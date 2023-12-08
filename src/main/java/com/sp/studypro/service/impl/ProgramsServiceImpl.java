package com.sp.studypro.service.impl;

import com.sp.studypro.mapper.ProgramsMapper;
import com.sp.studypro.mapper.dto.ProgramsDto;
import com.sp.studypro.model.ProgramsModel;
import com.sp.studypro.repository.ProgramsRepository;
import com.sp.studypro.service.ProgramsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramsServiceImpl implements ProgramsService {

    private final ProgramsRepository programsRepository;
    private final ProgramsMapper programsMapper;

    public ProgramsServiceImpl(ProgramsRepository programsRepository, ProgramsMapper programsMapper) {
        this.programsRepository = programsRepository;
        this.programsMapper = programsMapper;
    }

    @Override
    public ProgramsDto addNewPrograms(String underGraduate, String postGraduate) {
        ProgramsModel programsModel = programsRepository.save(
                new ProgramsModel(
                        underGraduate,
                        postGraduate
                )
        );

        return programsMapper.toProgramsDto(programsModel);
    }

    @Override
    public ProgramsDto addNewUnderGraduate(String underGraduate) {
        ProgramsModel programsModel = programsRepository.save(
                new ProgramsModel(
                        underGraduate,
                        null
                )
        );

        return programsMapper.toProgramsDto(programsModel);
    }

    @Override
    public ProgramsDto addNewPostGraduate(String postGraduate) {
        ProgramsModel programsModel = programsRepository.save(
                new ProgramsModel(
                        null,
                        postGraduate
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
    public List<ProgramsDto> getProgramByUnderGraduate(String underGraduate) {
        List<ProgramsModel> programsModel = programsRepository.findAllByUnderGraduate(underGraduate);
        return programsModel.stream()
                .map(programsMapper::toProgramsDto)
                .toList();
    }

    @Override
    public List<ProgramsDto>  getProgramByPostGraduate(String postGraduate) {
        List<ProgramsModel> programsModel = programsRepository.findAllByPostGraduate(postGraduate);
        return programsModel.stream()
                .map(programsMapper::toProgramsDto)
                .toList();
    }

    @Override
    public ProgramsDto updateProgram(Long id, String underGraduate, String postGraduate) {
        ProgramsModel upgradeProgramsModels = programsRepository.findById(id)
                .orElseThrow();

        upgradeProgramsModels.setId(id);
        upgradeProgramsModels.setUnderGraduate(underGraduate);
        upgradeProgramsModels.setPostGraduate(postGraduate);


        return programsMapper.toProgramsDto(upgradeProgramsModels);
    }

    @Override
    public void deleteProgramsById(Long id) {
        programsRepository.deleteById(id);
    }
}
