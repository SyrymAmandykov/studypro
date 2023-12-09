package com.sp.studypro.controller.users;

import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUsersRequest {

    private String email;
    private String password;
    private String fullName;
    private Integer age;
    private Role role;
    private Gender gender;
}
