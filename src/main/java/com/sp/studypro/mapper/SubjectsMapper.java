package com.sp.studypro.mapper;

import com.sp.studypro.mapper.dto.SubjectsDto;
import com.sp.studypro.model.SubjectsModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SubjectsMapper {

    SubjectsDto toSubjectsDto(SubjectsModel subjectsModel);

}
