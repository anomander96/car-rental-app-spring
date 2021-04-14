package com.lab.app.mapper;

import com.lab.app.dto.UserDto;
import com.lab.app.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto mapUserToUserDto(User user);

    User mapUserDtoToUser(UserDto userDto);
}
