package com.tms.service;

import com.tms.model.User;

public interface UserService {

    void save (User user);
    boolean isAuth(String username, String password);
    void logOut(String Username);

}
