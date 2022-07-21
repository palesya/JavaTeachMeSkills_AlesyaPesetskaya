package com.tms.service.impl;

import com.tms.aop.BenchMark;
import com.tms.model.User;
import com.tms.repository.UserRepository;
import com.tms.repository.UserValidator;
import com.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserValidator validator;

    @Override
    @SneakyThrows
    public void save(User user) {
        if (validator.validate(user)) {
            repository.save(user);
        } else {
            System.out.println("user is not valid");
        }
    }

    @Override
    @SneakyThrows
    @BenchMark
    public List<User> getUsers() {
        System.out.println("get all:");
        return repository.getUsers();
    }

    @Override
    @SneakyThrows
    public int count() {
        int size = repository.getUsers().size();
        return size;
    }
}
