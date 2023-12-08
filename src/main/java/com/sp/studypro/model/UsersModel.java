package com.sp.studypro.model;

import com.sp.studypro.abstract_base.BaseModel;
import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersModel extends BaseModel {

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "fullName",nullable = false)
    private String fullName;

    @Column(name = "age",nullable = false)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
