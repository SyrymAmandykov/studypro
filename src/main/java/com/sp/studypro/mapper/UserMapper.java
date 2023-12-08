package com.sp.studypro.mapper;

import com.sp.studypro.mapper.dto.UsersDto;
import com.sp.studypro.model.UsersModel;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UsersDto toUsersDto(UsersModel usersModel);

}
