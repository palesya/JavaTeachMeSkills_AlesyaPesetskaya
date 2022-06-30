package com.objects;

import com.exceptions.SaveUserException;

import java.util.List;
import java.util.stream.Collectors;

public class UserContainer {

    private List<User> userList;

    public UserContainer(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void saveUser(User user) {
        if (checkIfLoginExists(user)) {
            throw new SaveUserException("Such login already exists.");
        } else {
            userList.add(user);
        }
    }

    private boolean checkIfLoginExists(User user) {
        String login = user.getLogin();
        long count = userList.stream().filter(el -> login.equals(el.getLogin())).count();
        return count > 0;
    }

    public boolean checkIfLoginAndPasswordExists(String login, String password) {
        long count = userList.stream()
                .filter(user -> login.equals(user.getLogin()))
                .filter(user -> password.equals(user.getPassword())).count();
        return count > 0;
    }

    public List<User.Role> getRoleFromLoginPage(String login, String password) {
        return userList.stream()
                .filter(user -> login.equals(user.getLogin()))
                .filter(user -> password.equals(user.getPassword())).map(User::getRole).collect(Collectors.toList());
    }

}
