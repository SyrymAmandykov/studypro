package com.sp.studypro.controller.users;

import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import lombok.*;

@Getter
@Setter
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
