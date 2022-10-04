package com.example.full_test.service;

import com.example.full_test.model.User;

public interface UserValidator {

    boolean isValidForSave(User user);
    boolean isValidForUpdate(User user);
    boolean isValidForDelete(User user);

}
