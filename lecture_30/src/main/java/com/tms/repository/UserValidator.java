package com.tms.repository;

import com.tms.model.User;

public interface UserValidator {

    boolean validate(User user);
}
