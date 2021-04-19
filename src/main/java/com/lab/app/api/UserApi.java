package com.lab.app.api;

import com.lab.app.controller.model.UserModel;
import com.lab.app.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "User management API")
@RequestMapping(value = "/api/v1/users")
public interface UserApi {

    @ApiOperation("Getting user from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    UserModel getUser(@PathVariable String email);

    @ApiOperation("Creating user")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@Valid @RequestBody UserDto userDto);

    @ApiOperation("Updating user")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    UserModel updateUser(@PathVariable String email, @Valid @RequestBody UserDto userDto);

    @ApiOperation("Deleting user")
    @DeleteMapping(value = "/{email}")
    ResponseEntity<Void> deleteUser(@PathVariable String email);
}
