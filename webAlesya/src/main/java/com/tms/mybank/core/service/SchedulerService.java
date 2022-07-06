package com.tms.mybank.core.service;

import com.tms.mybank.core.dao.UserRepository;
import com.tms.mybank.core.entity.User;
import java.util.List;

public class SchedulerService {

    private UserService userService = new UserService();
    private UserRepository repository;

    void updateStatus() {
        List<User> users = repository.getAll();
        users.forEach(userService::update);
    }

}
