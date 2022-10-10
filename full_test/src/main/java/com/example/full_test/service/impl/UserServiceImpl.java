package com.example.full_test.service.impl;

import com.example.full_test.dto.UserDto;
import com.example.full_test.exception.UserAlreadyExistException;
import com.example.full_test.exception.UserNotValidException;
import com.example.full_test.model.User;
import com.example.full_test.repository.UserRepository;
import com.example.full_test.service.UserService;
import com.example.full_test.service.UserValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public UserDto getById(Long id) {
        User byId = repository.getById(id);
        UserDto build = UserDto.builder()
                .id(byId.getId())
                .login(byId.getLogin())
                .password(byId.getPassword()).build();
        return build;
    }

    @Override
    public User getByLogin(String login) {
        return repository.getByLogin(login);
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {

        User user = new User(userDto.getId(), userDto.getLogin(), userDto.getPassword());

        if (validator.isValidForSave(user)) {
            User byLogin = repository.getByLogin(user.getLogin());
            if (byLogin == null) {
                if(user.getPassword()==null||user.getPassword().isBlank()){
                    user.setPassword("default");
                }
                User save = repository.save(user);
                return UserDto.builder()
                        .id(save.getId())
                        .login(save.getLogin())
                        .password(save.getPassword())
                        .build();
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
