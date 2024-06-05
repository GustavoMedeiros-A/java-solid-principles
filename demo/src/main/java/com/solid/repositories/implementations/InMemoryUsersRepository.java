package com.solid.repositories.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solid.entities.User;
import com.solid.repositories.IUsersRepository;

public class InMemoryUsersRepository implements IUsersRepository {
    private List<User> users = new ArrayList<>();

    public InMemoryUsersRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
