package com.example.full_test.repository;

import com.example.full_test.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    List<User> users = new ArrayList<>();

    @BeforeEach
    public void before() {
        repository.deleteAll();
        User user1 = User.builder()
                .login("Alesya")
                .password("123")
                .build();

        User user2 = User.builder()
                .login("Pavel")
                .password("456")
                .build();

        users.add(user1);
        users.add(user2);

        repository.saveAll(users);
    }

    @Test
    void getByLoginNotExist() {
        User testUser = repository.getByLogin("test");
        assertNull(testUser);
    }

    @Test
    void getByLoginExists() {
        User testUser = repository.getByLogin("Alesya");
        Assertions.assertNotNull(testUser);
        assertEquals("Alesya", testUser.getLogin());
    }

    @Test
    void getAll() {
        List<User> allUsersInRepository = repository.findAll();

        assertEquals(2, allUsersInRepository.size());

        allUsersInRepository.forEach(
                user -> assertNotNull(user.getId())
        );
    }

}
