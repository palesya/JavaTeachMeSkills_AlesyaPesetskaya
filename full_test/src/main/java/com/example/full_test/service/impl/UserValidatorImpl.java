package com.example.full_test.service.impl;

import com.example.full_test.model.User;
import com.example.full_test.service.UserValidator;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean isValidForSave(User user) {
        Long id = user.getId();
        if (id != null) {
            return false;
        }

        String login = user.getLogin();
        if (login == null || login.isBlank()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean isValidForUpdate(User user) {
        Long id = user.getId();

        if (id == null) {
            return false;
        }

        String login = user.getLogin();

        if (login == null || login.isBlank()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidForDelete(User user) {
        return false;
    }
}
