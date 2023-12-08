package com.sp.studypro.service.impl;

import com.sp.studypro.mapper.SubjectsMapper;
import com.sp.studypro.mapper.dto.SubjectsDto;
import com.sp.studypro.model.SubjectsModel;
import com.sp.studypro.repository.SubjectsRepository;
import com.sp.studypro.service.SubjectsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    private final SubjectsRepository subjectsRepository;
    private final SubjectsMapper subjectsMapper;

    public SubjectsServiceImpl(SubjectsRepository subjectsRepository, SubjectsMapper subjectsMapper) {
        this.subjectsRepository = subjectsRepository;
        this.subjectsMapper = subjectsMapper;
    }

    @Override
    public SubjectsDto addNewSubjects(String name) {
        SubjectsModel subjectsModel = subjectsRepository.save(
                new SubjectsModel(
                        name
                )
        );

        return subjectsMapper.toSubjectsDto(subjectsModel);
    }

    @Override
    public SubjectsDto getSubjectsById(Long id) {
        SubjectsModel subjectsModel = subjectsRepository.findById(id)
                .orElseThrow();
        return subjectsMapper.toSubjectsDto(subjectsModel);
    }

    @Override
    public List<SubjectsDto> getAllSubjects() {
        List<SubjectsModel> subjectsModels = subjectsRepository.findAll();
                return subjectsModels.stream()
                        .map(subjectsMapper::toSubjectsDto)
                        .toList();
    }

    @Override
    public SubjectsDto updateSubjects(Long id, String name) {
        SubjectsModel updateSubjectsModel = subjectsRepository.getReferenceById(id);

        if (updateSubjectsModel.getId() == null){
            throw new IllegalArgumentException("Subjects id not found");
        }
        updateSubjectsModel.setId(id);
        updateSubjectsModel.setName(name);

        return subjectsMapper.toSubjectsDto(updateSubjectsModel);
    }

    @Override
    public void deleteSubjectsById(Long id) {
        subjectsRepository.deleteById(id);

    }
}
