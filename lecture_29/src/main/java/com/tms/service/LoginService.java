package com.tms.service;

import com.tms.model.User;

public interface LoginService {

    void saveUser(User user);
    boolean isAuth(String username, String password);
    void logOut(String username);

}
