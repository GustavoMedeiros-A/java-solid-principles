package com.solid.users.useCases.createUser;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.solid.users.entities.User;
import com.solid.users.repositories.implementations.InMemoryUsersRepository;
import com.solid.users.useCases.CreateUser.CreateUserRequestDto;
import com.solid.users.useCases.CreateUser.CreateUserUseCase;

public class CreateUserUseCaseTest {
    @Mock
    private InMemoryUsersRepository usersRepository;

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateAUser() {
        var request = new CreateUserRequestDto("Mario", "mario@mario.com", "123");

        when(usersRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());

        createUserUseCase.execute(request);

        verify(usersRepository, times(1)).save(any(User.class));
    }
}
