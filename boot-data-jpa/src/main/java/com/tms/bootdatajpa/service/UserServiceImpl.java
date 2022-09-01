package com.tms.bootdatajpa.service;

import com.tms.bootdatajpa.model.User;
import com.tms.bootdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }
}
