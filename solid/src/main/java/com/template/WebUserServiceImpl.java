package com.template;

public class WebUserServiceImpl extends UserService{
    @Override
    protected boolean isValidUser(User user) {
        return user.getLogin()!=null&&user.getPassword()!=null&&user.getEmail()!=null;
    }
}
