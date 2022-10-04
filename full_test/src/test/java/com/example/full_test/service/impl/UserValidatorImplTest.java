package com.example.full_test.service.impl;

import com.example.full_test.model.User;
import com.example.full_test.service.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserValidatorImplTest {

    @DisplayName("validate save with name")
    @Test
    public void givenValidUserForSave() {
        UserValidator validator = new UserValidatorImpl();
        User user = User.builder().login("Alesya").build();
        boolean validForSave = validator.isValidForSave(user);
        Assertions.assertTrue(validForSave);
    }

    @DisplayName("validate save with id")
    @Test
    public void givenInvalidUserForSave() {
        UserValidator validator = new UserValidatorImpl();
        User user = User.builder().login("Alesya").id(15L).build();
        boolean validForSave = validator.isValidForSave(user);
        Assertions.assertFalse(validForSave);
    }

    @DisplayName("validate save with empty login")
    @Test
    public void givenInvalidUserForSaveEmptyLogin() {
        UserValidator validator = new UserValidatorImpl();
        User user = User.builder().login("   ").build();
        boolean validForSave = validator.isValidForSave(user);
        Assertions.assertFalse(validForSave);
    }

}
