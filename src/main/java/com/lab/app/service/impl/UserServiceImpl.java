package com.lab.app.service.impl;

import com.lab.app.dto.UserDto;
import com.lab.app.mapper.UserMapper;
import com.lab.app.model.User;
import com.lab.app.repository.UserRepository;
import com.lab.app.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserMapper {

    private final UserRepository userRepository;

    @Override
    public UserDto getUser(String email) {
        User user = userRepository.getUser(email);
        log.info("|| Service layer: Getting a user with id: {} ||", email);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        log.info("|| Service layer: Creating a new user ||");
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        log.info("|| Service layer: Updating a user with id: {} ||", email);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("|| Service layer: Deleting a user with email: {} ||", email);
        userRepository.deleteUser(email);
    }

    @Override
    public UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userRoleId(user.getUserRoleId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .email(user.getEmail())
                .phone(user.getPhone())
                .passport(user.getPassport())
                .isBlocked(user.isBlocked())
                .build();
    }

    @Override
    public User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .userId(userDto.getUserId())
                .userRoleId(userDto.getUserRoleId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .phone(userDto.getPhone())
                .passport(userDto.getPassport())
                .isBlocked(userDto.isBlocked())
                .build();
    }
}
