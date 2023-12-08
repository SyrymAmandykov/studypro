package com.sp.studypro.mapper;

import com.sp.studypro.mapper.dto.ProgramsDto;
import com.sp.studypro.model.ProgramsModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProgramsMapper {

    ProgramsDto toProgramsDto(ProgramsModel programsModel);

}
