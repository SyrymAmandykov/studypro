package com.sp.studypro.mapper;

import com.sp.studypro.mapper.dto.CountriesDto;
import com.sp.studypro.model.CountriesModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CountriesMapper {

    CountriesDto toCountriesDto(CountriesModel countriesModel);

}
