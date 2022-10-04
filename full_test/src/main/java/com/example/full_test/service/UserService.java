package com.example.full_test.service;

import com.example.full_test.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getById(Long id);
    User getByLogin(String login);
    User save(User user);
    void delete(User user);
    User update(User user);

    void save(String login);
}
