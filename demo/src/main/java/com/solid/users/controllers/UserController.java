package com.solid.users.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.solid.users.entities.User;
import com.solid.users.useCases.CreateUser.CreateUserRequestDto;
import com.solid.users.useCases.CreateUser.CreateUserUseCase;
import com.solid.users.useCases.FindAllUsers.FindAllUsersUseCase;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            FindAllUsersUseCase findAllUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserRequestDto entity) {
        createUserUseCase.execute(entity);
    }

    @GetMapping
    public List<User> findAll() {
        return findAllUsersUseCase.execute();
    }

}
