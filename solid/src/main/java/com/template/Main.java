package com.template;

public class Main {
    public static void main(String[] args) {

        User user = new User.UserBuilder()
                .withLogin("asd")
                .withRole(Role.USER)
                .withPassword("dkvnwl").build();

        UserService web = new WebUserServiceImpl();
        UserService admin = new AdminUserServiceImpl();
        web.saveUser(user);
        admin.saveUser(user);

    }
}
