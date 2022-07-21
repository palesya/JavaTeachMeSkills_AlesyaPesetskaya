package com.tms.repository;

import com.tms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    public static final String SAVE_SQL = "insert into users (id, name, password) values(?,?,?)";
    public static final String GET_ALL_SQL = "select * from users";

    @Autowired
    private Connection connection;

    @Override
    public void save(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(SAVE_SQL);
        statement.setInt(1,user.getId());
        statement.setString(2,user.getName());
        statement.setString(3,user.getPassword());
        statement.execute();
        statement.close();
    }

    @Override
    public List<User> getUsers() throws SQLException {
        PreparedStatement statement = connection.prepareStatement(GET_ALL_SQL);
        ResultSet resultSet = statement.executeQuery();
        return getAllUsers(resultSet,statement);
    }

    private List<User> getAllUsers(ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            User user = new User(id, name,password);
            users.add(user);
        }
        preparedStatement.close();
        return users;
    }
}
