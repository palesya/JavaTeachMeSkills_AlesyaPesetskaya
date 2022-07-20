package com.tms;

import com.tms.model.User;
import com.tms.service.LoginService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Alesya","pass1", 32, true);
        User user2 = new User("Pavel","pass2", 33, false);
        User user3 = new User("Sofiya","pass3",9 , true);

        AbstractApplicationContext context=new AnnotationConfigApplicationContext("com.tms");
        LoginService userService = context.getBean(LoginService.class);
        context.registerShutdownHook();
        System.out.println("-------------------");
        userService.saveUser(user1);
        System.out.println("-------------------");
        userService.saveUser(user2);
        System.out.println("-------------------");
        userService.saveUser(user3);
    }
}
