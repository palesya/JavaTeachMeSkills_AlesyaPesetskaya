package com.tms.service.impl;

import com.tms.model.DataBase;
import com.tms.model.User;
import com.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("userFileService")
public class UserFileServiceImpl implements UserService {

    @Autowired
    private DataBase dataBase;

    public UserFileServiceImpl() {
    }

    @Override
    public void save(User user) {
        System.out.println("User is saved to file");
        dataBase.addUser(user);
    }

    @Override
    public boolean isAuth(String username, String password) {
        return false;
    }

    @Override
    public void logOut(String Username) {

    }
}
