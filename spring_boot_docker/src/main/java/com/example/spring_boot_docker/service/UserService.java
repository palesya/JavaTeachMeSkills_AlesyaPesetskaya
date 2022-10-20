package com.example.spring_boot_docker.service;

import com.example.spring_boot_docker.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void save(User user);
}
