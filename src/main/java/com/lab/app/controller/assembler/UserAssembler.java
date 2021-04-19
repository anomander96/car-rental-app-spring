package com.lab.app.controller.assembler;

import com.lab.app.controller.UserController;
import com.lab.app.controller.model.UserModel;
import com.lab.app.dto.UserDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link getUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(UserController.class)
                .getUser(entity.getEmail()))
                .withRel("getUser");

        Link updateUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(UserController.class)
                .updateUser(entity.getEmail(), entity))
                .withRel("updateUser");

        Link deleteUser = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(UserController.class)
                .deleteUser(entity.getEmail()))
                .withRel("deleteUser");

        userModel.add(getUser, updateUser, deleteUser);
        return userModel;
    }
}
