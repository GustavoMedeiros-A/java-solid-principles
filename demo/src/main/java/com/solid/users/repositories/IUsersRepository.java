package com.solid.users.repositories;

import java.util.List;
import java.util.Optional;

import com.solid.users.entities.User;

public interface IUsersRepository {
    Optional<User> findByEmail(String email);

    void save(User user);

    List<User> findAll();
}
