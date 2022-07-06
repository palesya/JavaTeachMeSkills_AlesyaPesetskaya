package com.tms.mybank.core.service;

import com.tms.mybank.core.entity.User;

public class UserValidator {

    void validForSave(User user) {
        String name = user.getName();
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    void validForUpdate(User user) {

    }

}
