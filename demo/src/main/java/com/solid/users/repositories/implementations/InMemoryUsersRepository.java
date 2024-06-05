package com.solid.users.repositories.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solid.users.entities.User;
import com.solid.users.repositories.IUsersRepository;

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

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}
