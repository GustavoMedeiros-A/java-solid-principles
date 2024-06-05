package com.solid.users.useCases.FindAllUsers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.solid.users.entities.User;
import com.solid.users.repositories.implementations.InMemoryUsersRepository;

@Service
public class FindAllUsersUseCase {
    private final InMemoryUsersRepository usersRepository;

    public FindAllUsersUseCase(InMemoryUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> execute() {
        var users = usersRepository.findAll();

        if (users.size() == 0) {
            throw new IllegalStateException("Not found users");
        }

        return users;
    }
}
