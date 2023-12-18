package com.sp.studypro.controller;

import com.sp.studypro.controller.users.AddUsersRequest;
import com.sp.studypro.controller.users.GetAllUsersResponse;
import com.sp.studypro.controller.users.UpdateUsersRequest;
import com.sp.studypro.mapper.dto.UsersDto;
import com.sp.studypro.service.UsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/users/add")
    @ResponseBody
    public UsersDto addNewUser(
            @RequestBody AddUsersRequest addUsersRequest
    ){
        return usersService.addNewUser(
                addUsersRequest.getEmail(),
                addUsersRequest.getPassword(),
                addUsersRequest.getFullName(),
                addUsersRequest.getAge(),
                addUsersRequest.getGender(),
                addUsersRequest.getRole()
        );
    }

    @GetMapping("/users/all")
    @ResponseBody
    public GetAllUsersResponse getAllUsers(){
        List<UsersDto> users = usersService.getAllUsers();
        return new GetAllUsersResponse(users);
    }

    @GetMapping("/users/{userId}")
    @ResponseBody
    public UsersDto getUserById(
            @PathVariable Long userId
    ) {
        return usersService.getUserById(userId);
    }

    @GetMapping("/users/{userEmail}")
    @ResponseBody
    public UsersDto getUserByEmail(
            @PathVariable String userEmail
    ){

        return usersService.getUserByEmail(userEmail);

    }

    @PutMapping("/users/update")
    @ResponseBody
    public UsersDto updateUser(
            @RequestBody UpdateUsersRequest updateUsersRequest
            ) {
        usersService.updateUsers(
                updateUsersRequest.getId(),
                updateUsersRequest.getEmail(),
                updateUsersRequest.getPassword(),
                updateUsersRequest.getFullName(),
                updateUsersRequest.getAge(),
                updateUsersRequest.getRole(),
                updateUsersRequest.getGender()
        );

        return usersService.getUserById(updateUsersRequest.getId());
    }

    @DeleteMapping("/users/delete/{userId}")
    @ResponseBody
    public void deleteUser(
            @PathVariable Long userId
    ){
        usersService.deleteUserById(userId);
    }


//    @GetMapping("/userList")
//    public Page<UsersDto> getUsers(@RequestParam(defaultValue = "0") int page,
//                                   @RequestParam(defaultValue = "5") int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return usersService.getAllUsers(pageable);
//    }





}
