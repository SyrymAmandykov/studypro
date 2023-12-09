package com.sp.studypro.controller;

import com.sp.studypro.controller.users.AddUsersRequest;
import com.sp.studypro.controller.users.GetAllUsersResponse;
import com.sp.studypro.controller.users.UpdateUsersRequest;
import com.sp.studypro.mapper.dto.UsersDto;
import com.sp.studypro.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/users")
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

    @GetMapping("/usersList")
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

    @GetMapping("/users/by-email/{email}")
    @ResponseBody
    public UsersDto getUserByEmail(
            @PathVariable String email
    ){

        return usersService.getUserByEmail(email);

    }

    @PutMapping("/users")
    @ResponseBody
    public UsersDto updateUser(
            @RequestBody UpdateUsersRequest updateUsersRequest
            ) {
        usersService.updateUser(
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

    @DeleteMapping("/users")
    @ResponseBody
    public void deleteUser(
            @RequestParam Long id
    ){
        usersService.deleteUserById(id);
    }





}
