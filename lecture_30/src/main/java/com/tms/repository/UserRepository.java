package com.tms.repository;

import com.tms.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    void save(User user) throws SQLException;
    List<User> getUsers() throws SQLException;

}
