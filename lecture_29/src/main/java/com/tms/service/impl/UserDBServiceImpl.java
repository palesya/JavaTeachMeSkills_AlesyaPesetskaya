package com.tms.service.impl;

import com.tms.model.DataBase;
import com.tms.model.User;
import com.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userDBService")
public class UserDBServiceImpl implements UserService {

    @Autowired
    private DataBase store;

    public UserDBServiceImpl() {
    }

    @Override
    public void save(User user) {
        store.addUser(user);
    }

    @Override
    public boolean isAuth(String username, String password) {
        return false;
    }

    @Override
    public void logOut(String Username) {

    }
}
