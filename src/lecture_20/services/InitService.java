package lecture_20.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitService {

    private Connection connection;
    public static final String CREATE = "create table if not exists cars (id int primary key, number varchar, brand varchar, age int);";
    public static final String DELETE = "drop table if exists cars;";

    public InitService(Connection connection) {
        this.connection = connection;
    }

    public void init() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(DELETE);
            statement.execute(CREATE);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
