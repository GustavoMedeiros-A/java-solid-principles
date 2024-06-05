package com.solid.users.useCases.CreateUser;

import com.solid.users.entities.User;
import com.solid.users.repositories.implementations.InMemoryUsersRepository;

public class CreateUserUseCase {

    private InMemoryUsersRepository usersRepository;

    public CreateUserUseCase(InMemoryUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void execute(CreateUserRequestDto createUserRequest) {
        if (usersRepository.findByEmail(createUserRequest.getEmail()).isPresent()) {
            throw new IllegalStateException("User already exists");
        }

        var user = new User(createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getPassword());
        usersRepository.save(user);
    }

}
