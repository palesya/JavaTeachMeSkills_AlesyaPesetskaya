package com.tms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    public static final String URL = "jdbc:postgresql://localhost/postgres";

    @Value("postgres")
    private String username;
    @Value("alesya")
    private String password;

    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(URL,username,password);
    }

}
