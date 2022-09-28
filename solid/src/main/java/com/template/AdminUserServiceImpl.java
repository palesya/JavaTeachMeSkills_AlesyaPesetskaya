package com.template;

public class AdminUserServiceImpl extends UserService{
    @Override
    protected boolean isValidUser(User user) {
        return user.getLogin()!=null&&user.getRole()!=null;
    }
}
