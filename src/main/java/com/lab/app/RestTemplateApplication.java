package com.lab.app;

import com.lab.app.dto.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateApplication {

    private static final String CREATE_USER_REQUEST = "http://localhost:8080/api/v1/users";
    private static final String GET_USER_REQUEST = "http://localhost:8080/api/v1/users/user@mail.com";
    private static final String DELETE_USER_REQUEST = "http://localhost:8080/api/v1/users/user@mail.com";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> response = restTemplate.getForEntity(GET_USER_REQUEST, UserDto.class);

        // Should create a builder class, to use custom fields out of package
        UserDto user = UserDto.builder().build();

        HttpEntity<UserDto> request = new HttpEntity<>(user);

        ResponseEntity<UserDto> responseEntity = restTemplate.postForEntity(CREATE_USER_REQUEST, request, UserDto.class);

        // in progress
    }
}
