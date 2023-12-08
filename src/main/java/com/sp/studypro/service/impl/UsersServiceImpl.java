package com.sp.studypro.service.impl;

import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import com.sp.studypro.mapper.UserMapper;
import com.sp.studypro.mapper.dto.UsersDto;
import com.sp.studypro.model.UsersModel;
import com.sp.studypro.repository.UsersRepository;
import com.sp.studypro.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public UsersServiceImpl(UsersRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UsersDto addNewUser(String email, String password, String fullName, Integer age,Gender gender) {
        UsersModel usersModel = usersRepository.save(
                new UsersModel(
                        email,
                        password,
                        fullName,
                        age,
                        null,
                        null
                )
        );

        return userMapper.toUsersDto(usersModel);
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<UsersModel> usersModels = usersRepository.findAll();
        return usersModels.stream()
                .map(userMapper::toUsersDto)
                .toList();
    }

    @Override
    public UsersDto getUserById(Long id) {
        UsersModel usersModel = usersRepository.findById(id)
                .orElseThrow();
        return userMapper.toUsersDto(usersModel);
    }


    @Override
    public UsersDto getUserByEmailAndPassword(String email, String password) {
        UsersModel usersModel = usersRepository.findFirstByEmailAndPassword(email,password);
        return userMapper.toUsersDto(usersModel);
    }

    @Override
    public UsersDto updateUser(Long id, String email, String password, String fullName, Integer age,Role role,Gender gender) {
        UsersModel updatedUsersModel = usersRepository
                .findById(id)
                .orElseThrow();

        if (updatedUsersModel.getId() == null) {
            throw new IllegalArgumentException(("User id not found"));
        }

        updatedUsersModel.setId(id);
        updatedUsersModel.setEmail(email);
        updatedUsersModel.setPassword(password);
        updatedUsersModel.setFullName(fullName);
        updatedUsersModel.setAge(age);
        updatedUsersModel.setRole(role);
        updatedUsersModel.setGender(gender);

        return userMapper.toUsersDto(updatedUsersModel);

    }

    @Override
    public void deleteUserById(Long id) {
        usersRepository
                .deleteById(id);
    }
}
