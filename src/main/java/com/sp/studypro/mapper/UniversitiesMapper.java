package com.sp.studypro.mapper;

import com.sp.studypro.controller.universities.AddUniversitiesRequest;
import com.sp.studypro.mapper.dto.UniversitiesDto;
import com.sp.studypro.model.UniversitiesModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR,uses = {CountriesMapper.class,ProgramsMapper.class})
public interface UniversitiesMapper {

    UniversitiesModel toUniversitiesModel(AddUniversitiesRequest addUniversitiesRequest);
    UniversitiesDto toUniversitiesDto(UniversitiesModel universitiesModel);

}
