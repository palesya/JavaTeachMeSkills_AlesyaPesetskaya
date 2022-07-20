package com.tms.config;

import com.tms.model.DataBase;
import com.tms.service.UserService;
import com.tms.service.impl.UserDBServiceImpl;
import com.tms.service.impl.UserFileServiceImpl;
import org.springframework.context.annotation.Bean;

//@Configuration
public class SpringConfig {


    @Bean
    public DataBase database() {
        System.out.println("db");
        DataBase db = new DataBase();
        return db;
    }

    @Bean(initMethod = "init")
    public UserService userDBService() {
        UserService userService = new UserDBServiceImpl();
        return userService;
    }

    @Bean
    public UserService userFileService() {
        UserService userFileService = new UserFileServiceImpl();
        return userFileService;
    }

}


