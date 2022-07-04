package com.objects;

import java.util.*;
import java.util.stream.Collectors;

import static com.objects.User.Role.ADMIN;
import static com.objects.User.Role.USER;
import static com.objects.User.Sex.MAN;
import static com.objects.User.Sex.WOMAN;

public class UserContainer {

    private List<User> userList;
    List<User> defaultList = new ArrayList<>();

    public UserContainer() {
        defaultList.add(new User("Alesya", "pass", ADMIN, WOMAN));
        defaultList.add(new User("Pavel", "pass1", USER, MAN));
        this.userList = defaultList;

    }

    public void saveUser(User user) {
        userList.add(user);
    }

    public boolean checkIfLoginExists(String login) {
        return userList.stream()
                .anyMatch(el -> Objects.equals(el.getLogin(), login));
    }

    public List<User> returnUser(String login, String password) {
        return userList.stream()
                .filter(user -> login.equals(user.getLogin()) && password.equals(user.getPassword()))
                .collect(Collectors.toList());
    }

}
