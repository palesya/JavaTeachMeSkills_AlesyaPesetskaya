package com.tms.service;

import com.tms.model.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> getUsers();
    int count();

}
