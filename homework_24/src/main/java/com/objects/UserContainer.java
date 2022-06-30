package com.objects;

import com.exceptions.SaveUserException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.objects.User.Role.ADMIN;
import static com.objects.User.Role.USER;
import static com.objects.User.Sex.MAN;
import static com.objects.User.Sex.WOMAN;

public class UserContainer {

    private List<User> userList;
    List<User> defaultList = Arrays.asList(
            new User("Alesya", "pass", ADMIN, WOMAN),
            new User("Pavel", "pass1", USER, MAN));

    public UserContainer() {
        this.userList = defaultList;
    }

    public void saveUser(User user) {
        userList.add(user);
    }

    public boolean checkIfLoginExists(String login) {
        List<String> logins = userList.stream()
                .map(User::getLogin)
                .collect(Collectors.toList());
        return logins.contains(login);
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
