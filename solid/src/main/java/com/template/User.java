package com.template;

public class User {

    private String login;
    private String password;
    private String email;
    private Role role;


    public static final class UserBuilder {
        private String login;
        private String password;
        private String email;
        private Role role;

        UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withRole(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            User user = new User();
            user.email = this.email;
            user.login = this.login;
            user.password = this.password;
            user.role = this.role;
            return user;
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
