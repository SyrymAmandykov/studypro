package com.sp.studypro.mapper;

import com.sp.studypro.mapper.dto.UniversitiesDto;
import com.sp.studypro.model.UniversitiesModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR,uses = {CountriesMapper.class,ProgramsMapper.class})
public interface UniversitiesMapper {

    UniversitiesDto toUniversitiesDto(UniversitiesModel universitiesModel);

}
