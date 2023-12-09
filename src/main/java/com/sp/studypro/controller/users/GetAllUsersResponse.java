package com.sp.studypro.controller.users;

import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import com.sp.studypro.mapper.dto.UsersDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResponse {

    private List<UsersDto> users;
}
