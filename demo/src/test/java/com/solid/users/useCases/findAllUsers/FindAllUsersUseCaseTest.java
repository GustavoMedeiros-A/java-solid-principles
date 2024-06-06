package com.solid.users.useCases.findAllUsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.solid.users.entities.User;
import com.solid.users.repositories.implementations.InMemoryUsersRepository;
import com.solid.users.useCases.FindAllUsers.FindAllUsersUseCase;

public class FindAllUsersUseCaseTest {

    @Mock
    private InMemoryUsersRepository usersRepository;

    @InjectMocks
    private FindAllUsersUseCase findAllUsersUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllUsers() {
        User user1 = new User("John Doe", "john.doe@example.com", "password123");
        User user2 = new User("Jane Doe", "jane.doe@example.com", "password456");

        when(usersRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = findAllUsersUseCase.execute();

        assertEquals(2, users.size());
        assertEquals("John Doe", users.get(0).getName());
        assertEquals("Jane Doe", users.get(1).getName());
    }

}
