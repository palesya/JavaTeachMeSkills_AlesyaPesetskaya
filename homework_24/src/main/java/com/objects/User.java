package com.objects;

public class User {

    private String login;
    private String password;
    private Role role;
    private Sex sex;

    public enum Role {ADMIN, USER}
    public enum Sex {MAN, WOMAN}

    public User(String login, String password, Role role, Sex sex) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.sex = sex;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", sex=" + sex +
                '}';
    }
}
