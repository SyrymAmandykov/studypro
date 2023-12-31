package com.sp.studypro.service.impl;

import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import com.sp.studypro.mapper.UserMapper;
import com.sp.studypro.mapper.dto.UsersDto;
import com.sp.studypro.model.UsersModel;
import com.sp.studypro.repository.UsersRepository;
import com.sp.studypro.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public UsersDto addNewUser(String email, String password, String fullName, Integer age,Gender gender,Role role) {

        UsersModel usersModel = usersRepository.save(
                new UsersModel(
                        email,
                        password,
                        fullName,
                        age,
                        role,
                        gender
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
//    @Override
//    public Page<UsersDto> getAllUsers(Pageable pageable) {
//        // Используйте метод findAll с передачей объекта Pageable
//        Page<UsersModel> usersPage = usersRepository.findAll(pageable);
//        // Преобразуйте Page<UsersModel> в Page<UsersDto>
//        Page<UsersDto> usersDtoPage = usersPage.map(userMapper::toUsersDto);
//
//        return usersDtoPage;
//    }

    @Override
    public UsersDto getUserById(Long userId) {
        UsersModel usersModel = usersRepository.findUsersModelById(userId);
        return userMapper.toUsersDto(usersModel);
    }


    @Override
    public UsersDto getUserByEmail(String email) {
        UsersModel usersModel = usersRepository.findByEmail(email);
        if(usersModel.getEmail().isEmpty()){
            throw new IllegalArgumentException("User email not found");
        }
        return userMapper.toUsersDto(usersModel);
    }

    @Override
    public UsersDto updateUsers(Long id, String email, String password, String fullName, Integer age,
                               Role role,Gender gender) {
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

        usersRepository.save(
                updatedUsersModel
        );
        return userMapper.toUsersDto(updatedUsersModel);

    }

    @Override
    public void deleteUserById(Long id) {
        usersRepository
                .deleteById(id);
    }
}
