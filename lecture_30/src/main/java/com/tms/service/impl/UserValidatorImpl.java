package com.tms.service.impl;

import com.tms.model.User;
import com.tms.repository.UserValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {

        if (StringUtils.isBlank(user.getName()) ||
                StringUtils.isBlank(user.getPassword())) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }
}
