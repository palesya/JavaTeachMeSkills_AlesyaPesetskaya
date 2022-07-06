package com.tms.mybank.core.service;

import com.tms.mybank.core.dao.UserRepository;
import com.tms.mybank.core.entity.User;

public class UserService {

    private UserRepository repository = new UserRepository();
    private UserValidator validator = new UserValidator();

    public User save(User user) {
        validator.validForSave(user);
        User fromDB = repository.save(user);
        return fromDB;
    }

    public User update(User user){
        validator.validForUpdate(user);
        User fromDB = repository.update(user);
        return fromDB;
    }

}
