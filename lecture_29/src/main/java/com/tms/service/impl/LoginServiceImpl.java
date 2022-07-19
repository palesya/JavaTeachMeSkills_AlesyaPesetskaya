package com.tms.service.impl;

import com.tms.model.User;
import com.tms.service.LoginService;
import com.tms.service.UserService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class LoginServiceImpl implements LoginService, InitializingBean, DisposableBean, BeanNameAware {

    private UserService service;

    public LoginServiceImpl(@Qualifier("userDBService") UserService userService) {
        this.service=userService;
        System.out.println("login service constructor");
    }

//    @Autowired
//    public void print(DataBase db) {
//        System.out.println(dataBase.getUsers());
//    }

    @PostConstruct
    public void init() {
        System.out.println("Hello from init");
    }

    @PreDestroy
    public void destroyPreDestroy() {
        System.out.println("Hello from destroy");
    }

    @Override
    public void saveUser(User user) {
        service.save(user);
    }

    @Override
    public boolean isAuth(String username, String password) {
        return false;
    }

    @Override
    public void logOut(String username) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Hello from setBeanName");
    }
}
