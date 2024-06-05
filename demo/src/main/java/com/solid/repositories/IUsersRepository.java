package com.solid.repositories;

import com.solid.entities.User;
import java.util.Optional;

public interface IUsersRepository {
    Optional<User> findByEmail(String email);

    void save(User user);
}
