package com.sp.studypro.service;

import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import com.sp.studypro.mapper.dto.UsersDto;

import java.awt.print.Pageable;
import java.util.List;

public interface UsersService {

    UsersDto addNewUser(String email, String password, String fullName, Integer age,Gender gender,Role role);

    List<UsersDto> getAllUsers();

    /*Для отображеня данных профиля*/
    UsersDto getUserById(Long id);

    UsersDto updateUser(Long id, String email, String password, String fullName, Integer age, Role role,Gender gender);

    void deleteUserById(Long id);

    UsersDto getUserByEmail(String email);

}
