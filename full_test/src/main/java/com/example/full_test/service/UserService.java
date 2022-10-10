package com.example.full_test.service;

import com.example.full_test.dto.UserDto;
import com.example.full_test.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    UserDto getById(Long id);
    User getByLogin(String login);
    UserDto save(UserDto user);
    void delete(User user);
    User update(User user);

    void save(String login);
}
