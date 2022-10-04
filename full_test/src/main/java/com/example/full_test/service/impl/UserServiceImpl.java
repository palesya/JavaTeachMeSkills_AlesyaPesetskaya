package com.example.full_test.service.impl;

import com.example.full_test.exception.UserAlreadyExistException;
import com.example.full_test.exception.UserNotValidException;
import com.example.full_test.model.User;
import com.example.full_test.repository.UserRepository;
import com.example.full_test.service.UserService;
import com.example.full_test.service.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserValidator validator;
    private final UserRepository repository;

    public UserServiceImpl(UserValidator validator, UserRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public User getByLogin(String login) {
        return repository.getByLogin(login);
    }

    @Override
    public User save(User user) {
        if (validator.isValidForSave(user)) {
            User byLogin = repository.getByLogin(user.getLogin());
            if (byLogin == null) {
                return repository.save(user);
            } else {
                throw new UserAlreadyExistException();
            }
        } else {
            throw new UserNotValidException();
        }
    }


    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User update(User user) {
        if (validator.isValidForUpdate(user)) {
            return repository.save(user);
        }
        user.setId(null);
        return user;
    }

    @Override
    public void save(String login) {
        User user = User.builder()
                .login(login)
                .password("default")
                .build();
        repository.save(user);
    }
}
