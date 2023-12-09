package com.sp.studypro.mapper.dto;

import com.sp.studypro.abstract_base.BaseDto;
import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDto implements BaseDto {

    private String email;
    private String password;
    private String fullName;
    private Integer age;
    private Role role;
    private Gender gender;

}
