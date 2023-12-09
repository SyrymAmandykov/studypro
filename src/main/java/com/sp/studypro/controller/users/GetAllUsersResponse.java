package com.sp.studypro.controller.users;

import com.sp.studypro.enum_package.Gender;
import com.sp.studypro.enum_package.Role;
import com.sp.studypro.mapper.dto.UsersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllUsersResponse {

    private List<UsersDto> users;
}
