package com.example.full_test.service.impl;

import com.example.full_test.exception.UserAlreadyExistException;
import com.example.full_test.exception.UserNotValidException;
import com.example.full_test.model.User;
import com.example.full_test.repository.UserRepository;
import com.example.full_test.service.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository mockRepository;
    @Mock
    private UserValidator mockValidator;
    @InjectMocks
    private UserServiceImpl service;

    @Test
    void saveWithValidUser() {
        User user = User.builder()
                .login("Petya")
                .build();

        User userFromDB = User.builder()
                .id(20L)
                .login("Ivan")
                .build();

        Mockito.when(mockValidator.isValidForSave(user)).thenReturn(true);
        Mockito.when(mockRepository.save(user)).thenReturn(userFromDB);

        User save = service.save(user);

        Assertions.assertEquals(20L, save.getId());
    }

    @Test
    void saveWithExistUser() {
        User user = User.builder()
                .login("Ivan")
                .build();

        User userFromDB = User.builder()
                .id(20L)
                .login("Ivan")
                .build();

        Mockito.when(mockValidator.isValidForSave(user)).thenReturn(true);
        Mockito.when(mockRepository.getByLogin("Ivan")).thenReturn(userFromDB);

        Assertions.assertThrows(UserAlreadyExistException.class, () ->
                service.save(user));

        Mockito.verify(mockRepository, Mockito.never()).save(user);
    }

    @Test
    void saveUserWithId() {
        User user = User.builder()
                .id(20L)
                .login("Ivan")
                .build();

        //mockRepository = Mockito.mock(UserRepository.class);
        mockValidator = Mockito.mock(UserValidatorImpl.class);

        Mockito.when(mockValidator.isValidForSave(user)).thenCallRealMethod();

        service = new UserServiceImpl(mockValidator, mockRepository);

        Assertions.assertThrows(UserNotValidException.class, () -> service.save(user));
        Mockito.verify(mockRepository, Mockito.never()).getByLogin("Ivan");
        Mockito.verify(mockRepository, Mockito.never()).save(user);
    }

    @Test
    void saveUserOnlyLogin() {
        String login = "Vasya";

        service = new UserServiceImpl(null, mockRepository);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        service.save(login);

        //какой пользователь внутри метода save
        Mockito.verify(mockRepository).save(captor.capture());
        //вызвался 1 раз
        Mockito.verify(mockRepository, Mockito.times(1)).save(Mockito.any());

        User userFromCaptor = captor.getValue();

        Assertions.assertEquals("Vasya", userFromCaptor.getLogin());
        Assertions.assertEquals("default", userFromCaptor.getPassword());

        org.assertj.core.api.Assertions.assertThat(userFromCaptor.getLogin()).isEqualTo("Vasya");

    }

}
